package rabbitmq.services.impl;


import com.warehouseService.rabbitmq.configs.OrderStatusEnum;
import com.warehouseService.rabbitmq.domains.ProductOrder;
import com.warehouseService.rabbitmq.domains.User;
import com.warehouseService.rabbitmq.repositories.ProductOrderRepository;
import com.warehouseService.rabbitmq.services.ProductOrderService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductOrderServiceImpl implements ProductOrderService {

    @Autowired
    ProductOrderRepository productOrderRepository;

    @Override
    public List<ProductOrder> getAll() {
        return (List<ProductOrder>)productOrderRepository.findAll();
    }

    @Override
    public ProductOrder save(ProductOrder productOrder) {
        return productOrderRepository.save(productOrder);
    }

    @Override
    public ProductOrder get(Long id) {
        return productOrderRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        productOrderRepository.deleteById(id);
    }

    @Override
    public List<ProductOrder> findByStatus(String status) {

        if(status.equals("pending")){
            return  productOrderRepository.findAllByOrderStatus(OrderStatusEnum.PENDING);
        }else if(status.equals("accepted")){
            return  productOrderRepository.findAllByOrderStatus(OrderStatusEnum.ACCEPTED);
        }else if(status.equals("on-the-way")){
            return  productOrderRepository.findAllByOrderStatus(OrderStatusEnum.ON_THE_WAY);
        }else if(status.equals("delivered")){
            return  productOrderRepository.findAllByOrderStatus(OrderStatusEnum.DELIVERED);
        }else if(status.equals("declined")){
            return  productOrderRepository.findAllByOrderStatus(OrderStatusEnum.DECLINED);
        }else{
            return (List<ProductOrder>)productOrderRepository.findAll();
        }

    }

    @Override
    public List<ProductOrder> findByBuyer(User user) {
        return productOrderRepository.findAllByBuyer(user);
    }

    @Override
    public ProductOrder changeStatus(String status, Long id) throws NotFoundException {
        Optional<ProductOrder> productOrderOption = productOrderRepository.findById(id);
        if(productOrderOption.isPresent()){
            ProductOrder productOrder = productOrderOption.get();
            if(status.equals("pending")){

                productOrder.setOrderStatus(OrderStatusEnum.PENDING);
            }else if(status.equals("accepted")){
                productOrder.setOrderStatus(OrderStatusEnum.ACCEPTED);
            }else if(status.equals("on-the-way")){
                productOrder.setOrderStatus(OrderStatusEnum.ON_THE_WAY);
            }else if(status.equals("delivered")){
                productOrder.setOrderStatus(OrderStatusEnum.DELIVERED);
            }else if(status.equals("declined")){
                productOrder.setOrderStatus(OrderStatusEnum.DECLINED);
            }
            return productOrderRepository.save(productOrder);
        }else{
            throw new NotFoundException("Order Not Found");
        }

    }

}
