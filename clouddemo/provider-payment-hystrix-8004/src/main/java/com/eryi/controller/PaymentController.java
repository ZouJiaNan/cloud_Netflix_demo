package com.eryi.controller;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
public class PaymentController {
    @GetMapping(value = "/hystrix/error")
    public String paymentinfo_error(){
        try {
            int i=1/0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "访问成功！";
    }

    @GetMapping(value = "/hystrix/timeout")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String paymentinfo_TimeOut(){
        //模拟一个高耗时的业务
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "访问成功！";
    }

    @GetMapping(value = "/hystrix/breaker/{id}")
    @HystrixCommand(
            fallbackMethod = "circuitbreaker_fallback",
            commandProperties = {
                    @HystrixProperty(name="circuitBreaker.enabled",value="true"),//开启断路器
                    @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),//请求次数
                    @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"),//熔断后，间隔多久再尝试恢复
                    @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60")//失败率阈值（%）
                    //10次请求中60%失败后触发熔断
            }
    )
    public String circuitbreaker(@PathVariable("id") Integer id){
        System.out.println("here......");
        if(id<0){
            throw new RuntimeException("id不能为负数！！！");
        }
        return Math.random()+"";
    }

    public String circuitbreaker_fallback(@PathVariable("id") Integer id){
        return "服务器暂时无法访问，请稍后再试！";
    }
}
