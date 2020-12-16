package com.eryi.controller;

import com.eryi.pojo.Payment;
import com.eryi.pojo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("payment")
public class OrderController {
    @Autowired
    RestTemplate restTemplate;

    private static  final String paymentService="http://PROVIDER-PAYMENT";

    //private static final String payment_url="http://127.0.0.1:8001";
    @PostMapping("create")
    public ResultBean create(Payment payment){
        return restTemplate.postForObject(paymentService+"/payment/create",payment,ResultBean.class);
    }

    @GetMapping(value = "get/{id}")
    public ResultBean getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(paymentService+"/payment/get/"+id,ResultBean.class);
    }
}
