package com.eryi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ZouJiaNan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年12月14日 17:32:00
 */
@SpringBootApplication
@EnableEurekaClient
public class streamRabbitMQ8801Application {
    public static void main(String[] args) {
        SpringApplication.run(streamRabbitMQ8801Application.class);
    }
}
