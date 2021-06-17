package com.windsun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.logging.LogLevel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName : ProductController
 * @Description :
 * @Author : ws
 * @Date: 2021-06-17 17:05
 * @Version 1.0
 */
@RestController
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Value("${server.port}")
    private int port;

    @GetMapping("/product")
    public String product(){
        log.info("进入商品服务");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        return "product : "+sdf.format(new Date())+"，当前端口为："+port;
    }

    @GetMapping("/productList")
    public String productList(){
        log.info("进入商品列表服务");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        return "productList : "+sdf.format(new Date())+"，当前端口为："+port;
    }
}