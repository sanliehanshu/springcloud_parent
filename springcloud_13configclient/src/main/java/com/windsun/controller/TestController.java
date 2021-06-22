package com.windsun.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : TestController
 * @Description :
 * @Author : ws
 * @Date: 2021-06-22 11:04
 * @Version 1.0
 */
@RestController
@Slf4j
@RefreshScope // 用来不重启当前应用的情况下，将当前scope域中信息刷新为最新配置
//同时curl post 请求http://ip:port/actuator/refresh
public class TestController {

    @Value("${name}")
    private String name;

    @RequestMapping("/test")
    public String test(){
        return "test，name："+name;
    }
}
