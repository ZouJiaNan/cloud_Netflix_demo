package com.eryi.controller;

import com.eryi.pojo.Payment;
import com.eryi.pojo.ResultBean;
import com.eryi.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("payment")
public class OrderController {
    @Autowired
    PaymentService paymentService;

    @GetMapping(value = "/hystrix/error")
    public String paymentinfo_error(){
        return paymentService.paymentinfo_error();
    }

    @GetMapping(value = "/hystrix/timeout")
    public String paymentinfo_TimeOut(){
     return paymentService.paymentinfo_TimeOut();
    }
    @GetMapping(value="/hystrix/breaker/{id}")
    public String breaker(@PathVariable("id")Integer id){
        return paymentService.circuitbreaker(id);
    }
}
