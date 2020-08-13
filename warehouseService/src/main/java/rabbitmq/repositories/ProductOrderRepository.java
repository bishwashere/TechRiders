package rabbitmq.repositories;


import com.warehouseService.rabbitmq.configs.OrderStatusEnum;
import com.warehouseService.rabbitmq.domains.ProductOrder;
import com.warehouseService.rabbitmq.domains.User;
import org.mapstruct.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOrderRepository extends CrudRepository<ProductOrder,Long> {

    List<ProductOrder> findAllByOrderStatus(OrderStatusEnum orderStatusEnum);

    List<ProductOrder> findAllByBuyer(User user);



}
