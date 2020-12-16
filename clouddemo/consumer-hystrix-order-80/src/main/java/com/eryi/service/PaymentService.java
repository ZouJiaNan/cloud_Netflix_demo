package com.eryi.service;

import com.eryi.fallback.PaymentServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//fallback = PaymentServiceFallBack.class

@Component
@FeignClient(value = "PROVIDER-PAYMENT")
public interface PaymentService {
    @GetMapping(value = "payment/hystrix/error")
    String paymentinfo_error();

    @GetMapping(value = "payment/hystrix/timeout")
    String paymentinfo_TimeOut();

    @GetMapping(value = "payment/hystrix/breaker/{id}")
    String circuitbreaker(@PathVariable("id") Integer id);
}
