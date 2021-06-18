package com.windsun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName : HystrixApplication
 * @Description :
 * @Author : ws
 * @Date: 2021-06-18 16:41
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker // 开启hystrix 服务熔断
public class HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class,args);
    }
}
