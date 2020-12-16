package com.eryi.service;

import com.eryi.pojo.Payment;
import com.eryi.pojo.ResultBean;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(value = "PROVIDER-PAYMENT")
public interface PaymentService {
    @PostMapping(value = "payment/create")
    ResultBean create(@RequestBody Payment payment);
    @GetMapping(value = "payment/get/{id}")
    ResultBean getPaymentById(@PathVariable("id") Long id);
    @GetMapping(value="payment/timeout")
    ResultBean timeout();
}
