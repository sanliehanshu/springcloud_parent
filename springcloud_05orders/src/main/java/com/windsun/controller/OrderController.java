package com.windsun.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName : OrderController
 * @Description :
 * @Author : ws
 * @Date: 2021-06-16 16:56
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/listOrder")
    public String listOrder(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        return "order : "+sdf.format(new Date())+"，当前端口为："+port;
    }
}
