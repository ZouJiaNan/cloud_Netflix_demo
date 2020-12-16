package com.eryi.fallback;/**
 * @author ZouJiaNan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年11月30日 16:07:00
 */

import com.eryi.service.PaymentService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ZouJiaNan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年11月30日 16:07:00
 */
@Component
public class PaymentServiceFallBack implements PaymentService {
    @Override
    public String paymentinfo_error() {
        return "访问失败！！！";
    }

    @Override
    public String paymentinfo_TimeOut() {
        return "访问超时！！！";
    }

    @Override
    public String circuitbreaker(Integer id) {
        return "id不能为负！！！";
    }
}
