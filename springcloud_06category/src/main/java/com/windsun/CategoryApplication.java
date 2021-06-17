package com.windsun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName : CategoryApplication
 * @Description :
 * @Author : ws
 * @Date: 2021-06-17 16:57
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient// 开启服务注册
@EnableFeignClients // 开启openFeign 客户端调用
public class CategoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CategoryApplication.class,args);
    }
}
