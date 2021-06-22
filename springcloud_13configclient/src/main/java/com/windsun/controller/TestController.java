package com.windsun.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
public class TestController {

    @Value("${name}")
    private String name;

    @RequestMapping("/test")
    public String test(){
        return "test，name："+name;
    }
}
