package com.windsun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName : OpenFeignHystrixApplication
 * @Description :
 * @Author : ws
 * @Date: 2021-06-18 20:53
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient // consul 注册中心支持
@EnableFeignClients // openfeign 服务调用支持
//@EnableCircuitBreaker // hystrix 熔断支持 不需要再显示声明
public class OpenFeignHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignHystrixApplication.class,args);
    }
}
