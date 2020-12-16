package com.eryi.service.serviceImpl;

import com.eryi.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author ZouJiaNan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年12月14日 17:35:00
 */
@EnableBinding(Source.class)//声明这是一个源（输入源、输出源）
public class IMessageImpl implements IMessageProvider {
    @Resource
    private MessageChannel output; //发送管道
    @Override
    public String send() {
        //消息体
        String serial= UUID.randomUUID().toString();
        //构建并且发送消息
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("******serial:"+serial);
        return null;
    }
}
