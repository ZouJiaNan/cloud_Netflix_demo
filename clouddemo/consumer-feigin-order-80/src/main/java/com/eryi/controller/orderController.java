package com.eryi.controller;

import com.eryi.pojo.Payment;
import com.eryi.pojo.ResultBean;
import com.eryi.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("payment")
public class orderController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("create")
    public ResultBean create(Payment payment) {
        return paymentService.create(payment);
    }

    @GetMapping(value = "get/{id}")
    public ResultBean getPaymentById(@PathVariable("id") Long id){
        return paymentService.getPaymentById(id);
    }


    @GetMapping(value="timeout")
    public ResultBean timeout(){
        //openFeign默认等待一秒，超时则报错
        return  paymentService.timeout();
    }

}
