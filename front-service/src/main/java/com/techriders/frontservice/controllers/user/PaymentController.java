package com.techriders.frontservice.controllers.user;

import com.techriders.frontservice.configs.OrderStatusEnum;
import com.techriders.frontservice.domains.*;
import com.techriders.frontservice.helpers.MyHelper;
import com.techriders.frontservice.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping(value = "/buyer/payment_input")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Autowired
    ProductOrderService productOrderService;

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;


    @Autowired
    BillingAddressService billingAddressService;

    @Autowired
    ShippingAddressService shippingAddressService;

    @Autowired
    JavaMailSender javaMailSender;


    @GetMapping(value = {"/", ""})
    public String paymentInput(@ModelAttribute("payment") Payment payment) {

        return "/user/paymentForm";
    }

    @PostMapping(value = {"/", ""})
    public String savePayment(@Valid @ModelAttribute("payment") Payment payment, BindingResult result, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "/user/paymentForm";
        } else {
            BillingAddress billingAddress = (BillingAddress) session.getAttribute("billingAddress");
            ShippingAddress shippingAddress = (ShippingAddress) session.getAttribute("shippingAddress");


            if(billingAddress ==null || shippingAddress == null){
                return "redirect:/";
            }

            billingAddress = billingAddressService.save(billingAddress);
            shippingAddress = shippingAddressService.save(shippingAddress);

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findByUserName(authentication.getName());

            ProductOrder productOrder = new ProductOrder();
            productOrder.setTransactionId(MyHelper.getRandomInt());
            productOrder.setBillingAddress(billingAddress);
            productOrder.setShippingAddress(shippingAddress);
            productOrder.setOrderStatus(OrderStatusEnum.PENDING);
            productOrder.setBuyer(user);


            //message is remaining

            Long points = 5l;

            //collecting product
            List<OrderedProduct> orderedProducts = new ArrayList<OrderedProduct>();
            List<Long> ids = new ArrayList<Long>();
            Map<Long,Product> products = (HashMap<Long,Product>)session.getAttribute("cart_item");
            for(Map.Entry<Long, Product> entry : products.entrySet()) {
                Long key = entry.getKey();
                Product p = entry.getValue();
                OrderedProduct orderedProduct = new OrderedProduct();
                orderedProduct.setPrice(p.getPrice());
                orderedProduct.setQty(p.getQty());
                orderedProduct.setTax(p.getTax());
                orderedProduct.setProduct(p);
                orderedProducts.add(orderedProduct);
                ids.add(p.getId());
            }

            productOrder.setOrderedProducts(orderedProducts);
            productOrderService.save(productOrder);

            try {
                SimpleMailMessage mail = new SimpleMailMessage();
                mail.setFrom("TechRiders");
                mail.setTo(user.getEmail());
                mail.setSubject("Order Placed.");
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Hi ");
                stringBuffer.append(user.getFirstName());
                stringBuffer.append(",");
                stringBuffer.append("\n");
                stringBuffer.append("You placed order in TechRiders successfully.\n");
                stringBuffer.append("We are very happy for choosing TechRiders.");
                stringBuffer.append("Your transaction Id is:"+productOrder.getTransactionId());
                stringBuffer.append("\nThank you.\n");
                stringBuffer.append("TechRiders Team");
                mail.setText(stringBuffer.toString());
                javaMailSender.send(mail);
            } catch (NoSuchElementException e) {

            } catch (NullPointerException e) {

            }

            userService.addPointsById(user.getId(),points);//adding 5 points to

            session.setAttribute("user_points",user.getPoints()+points);

            session.setAttribute("cart_item",null);

            paymentService.save(payment);
            redirectAttributes.addFlashAttribute(payment);
            return "redirect:/buyer/payment_input/payment-success";
        }

    }
    @GetMapping(value = {"/payment-success"})
    public String PaymentSuccess(Model model) {
        model.addAttribute("allPaymentMethod", paymentService.getAllPayment());
        return "/user/orderCompleted";
    }
    @GetMapping(value = {"/paymentList"})
    public String PaymentUpdate(Model model) {
        model.addAttribute("allPaymentMethod", paymentService.getAllPayment());
        return "/user/paymentSuccess";
    }

    @GetMapping("/editPayment/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Payment payment = paymentService.findById(id);
        model.addAttribute("paymentUpdate", payment);

        return "/user/update_Payment";
    }

    @PostMapping(value = {"/editPayment/update/{id}"})
    public String updatePayment(@PathVariable("id") long id, Payment payment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            payment.setId(id);
            return "/user/update_Payment";
        }
        paymentService.save(payment);
        model.addAttribute("allPaymentMethod", paymentService.getAllPayment());
        return "/user/paymentSuccess";
    }

    @GetMapping("/deletePayment/{id}")
    public String deleteUser(@PathVariable("id") long id, Payment payment, Model model) {
        payment = paymentService.findById(id);
        paymentService.delete(payment);
        model.addAttribute("allPaymentMethod", paymentService.getAllPayment());
        return "/user/paymentSuccess";
    }

}
