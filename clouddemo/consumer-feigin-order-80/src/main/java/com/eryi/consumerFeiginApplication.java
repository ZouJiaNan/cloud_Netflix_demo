package com.eryi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class consumerFeiginApplication {
    public static void main(String[] args) {
        SpringApplication.run(consumerFeiginApplication.class,args);
    }
}
