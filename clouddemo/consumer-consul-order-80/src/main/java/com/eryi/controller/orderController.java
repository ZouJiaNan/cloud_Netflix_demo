package com.eryi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("payment")
public class orderController {
    @Autowired
    RestTemplate restTemplate;

    private static  final String paymentService="http://provider-payment";

    @RequestMapping("consul")
    public String consul(){
        return restTemplate.getForObject(paymentService+"/payment/consul",String.class);
    }
}
