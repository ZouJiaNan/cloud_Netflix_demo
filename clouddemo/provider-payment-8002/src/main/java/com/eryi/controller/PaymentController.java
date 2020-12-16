package com.eryi.controller;

import com.eryi.pojo.Payment;
import com.eryi.pojo.ResultBean;
import com.eryi.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping(value = "create")
    public ResultBean create(@RequestBody Payment payment){
        int result=paymentService.create(payment);
        log.info("******插入结果："+result);
        return new ResultBean(result>0?200:500,result>0?"success":"false",result);
    }

    @GetMapping(value = "get/{id}")
    public ResultBean getPaymentById(@PathVariable("id") Long id){
        Payment payment=paymentService.getPaymentById(id);
        log.info("******查询结果："+payment);
        return new ResultBean(200,"success",payment);
    }

    @GetMapping(value = "test")
    public ResultBean test(){

        return new ResultBean(200,"success","test");
    }

}
