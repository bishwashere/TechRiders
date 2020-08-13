package rabbitmq.services.impl;


import com.warehouseService.rabbitmq.domains.Payment;
import com.warehouseService.rabbitmq.repositories.PaymentRepository;
import com.warehouseService.rabbitmq.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PaymentImpl implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    @Transactional
    public Payment save(Payment payment){
        return paymentRepository.save(payment);
    }
    @Transactional
    public List<Payment> getAllPayment(){
        return paymentRepository.findAll();
    }

    @Transactional
    public Payment findById(long id) {
        return paymentRepository.findById(id);
    }
    @Transactional
    public void delete(Payment Payment) {
        paymentRepository.delete(Payment);
    }
}
