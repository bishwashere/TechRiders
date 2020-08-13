<<<<<<< HEAD:warehouseService/src/main/java/com/techriders/logisticservice/repositories/ShippingAddressRepository.java
package com.techriders.logisticservice.repositories;


import com.techriders.logisticservice.domains.ShippingAddress;
=======
package com.warehouseService.rabbitmq.repositories;


import com.warehouseService.rabbitmq.domains.ShippingAddress;
>>>>>>> 74e49a5e86fbe11f21dd98e2f840978f217ebe7a:warehouseService/src/main/java/com/warehouseService/rabbitmq/repositories/ShippingAddressRepository.java
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShippingAddressRepository extends CrudRepository<ShippingAddress, Long> {
    public List<ShippingAddress> findAll();
    public ShippingAddress findById(long id);
}
