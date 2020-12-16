package com.eryi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class DiscoveryController {
    @Autowired
    DiscoveryClient client;

    @RequestMapping("payment/discovery")
    public Object discovery(){
        List<String> services=client.getServices();
        for(String element:services){
            log.info("******element:"+element);
        }

        List<ServiceInstance> instances=client.getInstances("PROVIDER-PAYMENT");
        for (ServiceInstance instance:instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return client;
    }
}
