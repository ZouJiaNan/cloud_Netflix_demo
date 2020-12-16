package com.eryi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZouJiaNan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年12月07日 18:02:00
 */
@RestController
@RefreshScope
public class configClientController {

    @Value("${spring.info}")
    String info;

    @GetMapping("getInfo")
    public String getInfo(){
        return info;
    }

}
