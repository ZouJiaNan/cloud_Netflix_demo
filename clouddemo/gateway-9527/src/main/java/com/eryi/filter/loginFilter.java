package com.eryi.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author ZouJiaNan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年12月03日 23:06:00
 */
@Component
@Slf4j
public class loginFilter implements GlobalFilter, Ordered {
    //过滤策略
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("****** come in!!!!!");
        String username=exchange.getRequest().getQueryParams().getFirst("username");
        if(username==null){
            log.info("****** username is null");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    //优先级，值越小越高。
    @Override
    public int getOrder() {
        return 0;
    }
}
