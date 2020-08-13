<<<<<<< HEAD:warehouseService/src/main/java/com/techriders/logisticservice/repositories/PaymentRepository.java
package com.techriders.logisticservice.repositories;


import com.techriders.logisticservice.domains.Payment;
=======
package com.warehouseService.rabbitmq.repositories;


import com.warehouseService.rabbitmq.domains.Payment;
>>>>>>> 74e49a5e86fbe11f21dd98e2f840978f217ebe7a:warehouseService/src/main/java/com/warehouseService/rabbitmq/repositories/PaymentRepository.java
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {
    public List<Payment> findAll();
    public Payment findById(long id);
}
