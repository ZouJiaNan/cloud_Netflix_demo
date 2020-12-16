package com.eryi.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    //负载均衡策略
    @Bean
    public IRule LBRule(){
        return new RoundRobinRule();
    }
}
