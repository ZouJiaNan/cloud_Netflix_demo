package com.eryi.service.serviceImpl;
import com.eryi.pojo.Payment;
import com.eryi.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import com.eryi.mapper.PaymentMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentMapper paymentMapper;
    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
