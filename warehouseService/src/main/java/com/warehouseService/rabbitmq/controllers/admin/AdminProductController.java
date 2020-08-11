package com.warehouseService.rabbitmq.controllers.admin;


import com.warehouseService.rabbitmq.domains.Product;
import com.warehouseService.rabbitmq.domains.User;
import com.warehouseService.rabbitmq.helpers.MyHelper;
import com.warehouseService.rabbitmq.services.CategoryService;
import com.warehouseService.rabbitmq.services.OrderedProductService;
import com.warehouseService.rabbitmq.services.ProductService;
import com.warehouseService.rabbitmq.services.UserService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping("/administration/product")
public class AdminProductController {
    @Autowired
    private MessageSource messageSource;

    @Autowired
    WebApplicationContext servletContext;

    @Autowired
    ProductService productService;


    @Autowired
    CategoryService categoryService;

    @Autowired
    OrderedProductService orderedProductService;


    @Autowired
    UserService userService;

    @ModelAttribute
    public void globalHandler(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user =  userService.findByUserName(authentication.getName());
        model.addAttribute("seller",user);
    }

    @GetMapping(value = {"", "/"})
    public String index(Model model) {
        model.addAttribute("products", productService.findAll());
        return "admin/product_list";
    }

    @GetMapping("/add")
    public String showProductForm(@ModelAttribute("product") Product product, Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "admin/product_form";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam("product_file") MultipartFile product_file, @Valid @ModelAttribute("product") Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model, HttpServletRequest httpRequest, Locale loc) {

        if (product_file == null) {

            String localeMsg = messageSource.getMessage("productPicRequired", null, null, loc);
            bindingResult.addError(new FieldError("product", "product_image", "", false, null, null, localeMsg));
        } else if (product_file.getSize() == 0) {
            String localeMsg = messageSource.getMessage("productPicRequired", null, null, loc);
            bindingResult.addError(new FieldError("product", "product_image", "", false, null, null, localeMsg));
        } else {
            String rootDirectory = httpRequest.getServletContext().getRealPath("/");
            try {
                String productName = MyHelper.getRandomInt() + "." + FilenameUtils.getExtension(product_file.getOriginalFilename());

                File file = new File(rootDirectory + "/images/");
                file.mkdirs();
                System.out.println("rootDirectoryrootDirectory");
                System.out.println(rootDirectory);
                product_file.transferTo(new File(rootDirectory + "/images/" + productName));
                product.setProductImage(productName);
            } catch (Exception e) {

                String localeMsg = messageSource.getMessage("unableToUpload", null, null, loc);
                bindingResult.addError(new FieldError("product", "product_image", "", false, null, null, localeMsg));
            }

        }
        if (bindingResult.hasErrors()) {

            model.addAttribute("categories", categoryService.findAll());
            return "admin/product_form";
        } else {

            product.setAddedBy(((User)model.getAttribute("seller")).getId());

            productService.save(product);
            redirectAttributes.addFlashAttribute("success_msg", "Product has been created successfully.");
            return "redirect:/administration/product";
        }


    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable("id") long id, Model model) {

        Optional<Product> employeeOptional = productService.findById(id);
        model.addAttribute("product", employeeOptional.get());

        model.addAttribute("categories", categoryService.findAll());
        return "user/product_form";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateEmployee(@RequestParam("product_file") MultipartFile product_file,@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, @PathVariable("id") long id,RedirectAttributes redirectAttributes, Model model,HttpServletRequest httpRequest,Locale loc) {
        if (product_file != null & product_file.getSize()>0){
            String rootDirectory = httpRequest.getServletContext().getRealPath("/");
            try {
                String productName = MyHelper.getRandomInt() + "." + FilenameUtils.getExtension(product_file.getOriginalFilename());

                File file = new File(rootDirectory + "/images/");
                file.mkdirs();
                System.out.println("rootDirectoryrootDirectory");
                System.out.println(rootDirectory);
                product_file.transferTo(new File(rootDirectory + "/images/" + productName));
                product.setProductImage(productName);
            } catch (Exception e) {

                String localeMsg = messageSource.getMessage("unableToUpload", null, null, loc);
                bindingResult.addError(new FieldError("product", "product_image", "", false, null, null, localeMsg));
            }
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "user/product_form";
        }else{
            redirectAttributes.addFlashAttribute("success_msg", "Product has been created successfully.");
            product.setId(id);
            productService.save(product);

            return ("redirect:/administration/product");
        }

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") long id, Model model,RedirectAttributes redirectAttributes) {
        Optional<Product> employeeOptional = productService.findById(id);
        if(employeeOptional.isPresent()){
            Product product = employeeOptional.get();

            if(orderedProductService.findByProductId(id) != null){

                redirectAttributes.addFlashAttribute("error_msg", "This product has been ordered by customer.");

            }else{

                productService.deleteById(id);
                redirectAttributes.addFlashAttribute("success_msg", "Product has been deleted successfully.");
            }

        }else{
            redirectAttributes.addFlashAttribute("error_msg", "Product not found.");
        }

        //pending to check order table
        return ("redirect:/administration/product");
    }

}
