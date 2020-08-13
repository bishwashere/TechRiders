package rabbitmq.services;


import com.warehouseService.rabbitmq.domains.OrderedProduct;

public interface OrderedProductService {

    OrderedProduct findByProductId(Long id);
}
