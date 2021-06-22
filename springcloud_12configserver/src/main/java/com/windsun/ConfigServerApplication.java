package com.windsun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @ClassName : ConfigServerApplication
 * @Description :
 * @Author : ws
 * @Date: 2021-06-22 08:34
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer // 统一配置中心服务
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class,args);
    }
}
