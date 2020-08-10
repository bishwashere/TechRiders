package com.techriders.wirehouseservice.repositories;


import com.techriders.wirehouseservice.domains.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {
    public List<Payment> findAll();
    public Payment findById(long id);
}
