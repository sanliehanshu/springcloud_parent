package com.windsun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName : OrdersApplication
 * @Description :
 * @Author : ws
 * @Date: 2021-06-16 16:29
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrdersApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdersApplication.class,args);
    }
}
