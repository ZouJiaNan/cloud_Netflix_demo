package com.eryi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//开启consul客户端
@EnableDiscoveryClient
public class payment8003Application {
    public static void main(String[] args) {
        SpringApplication.run(payment8003Application.class,args);
    }
}
