package com.windsun.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName : BeansConfig
 * @Description :
 * @Author : ws
 * @Date: 2021-06-17 15:26
 * @Version 1.0
 */
@Configuration
public class BeansConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
