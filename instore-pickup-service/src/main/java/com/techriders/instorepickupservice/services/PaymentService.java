package com.techriders.instorepickupservice.services;


import com.techriders.instorepickupservice.domains.Payment;

import java.util.List;

public interface PaymentService {

    public Payment save(Payment payment);
    public List<Payment> getAllPayment();

    public Payment findById(long id);

    public void delete(Payment Payment);
}
