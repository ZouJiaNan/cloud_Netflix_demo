package com.eryi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class paymentController {
    @RequestMapping("/payment/consul")
    public String paymentConsul(){
        return "springcloud with consul:"+8003+"\t"+ UUID.randomUUID().toString();
    }
}
