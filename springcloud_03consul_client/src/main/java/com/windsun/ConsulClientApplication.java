package com.windsun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName : ConsulClientApplication
 * @Description :
 * @Author : ws
 * @Date: 2021-06-16 15:11
 * @Version 1.0
 */
@SpringBootApplication
/**
 * 除了eureka以外其他注册中心的通用注解
 */
@EnableDiscoveryClient
public class ConsulClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulClientApplication.class,args);
    }
}
