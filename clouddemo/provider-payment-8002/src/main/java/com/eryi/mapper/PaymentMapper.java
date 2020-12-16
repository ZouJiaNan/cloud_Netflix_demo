package com.eryi.mapper;

import com.eryi.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PaymentMapper {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
