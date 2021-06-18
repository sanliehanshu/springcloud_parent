package com.windsun.controller;

import com.windsun.entry.Product;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.logging.LogLevel;
import org.springframework.web.bind.annotation.*;

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
@Slf4j
public class ProductController {

//    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Value("${server.port}")
    private int port;

    @GetMapping("/product")
    public String product(){
        log.info("进入商品服务");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        return "product : "+sdf.format(new Date())+"，当前端口为："+port;
    }

    /**
     * RequestParam 传参
     * @param name
     * @return
     */
    @GetMapping("/productName")
    public String product(@RequestParam("name") String name){
        log.info("进入商品服务");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        return "product : "+sdf.format(new Date())+"，当前端口为："+port+name;
    }

    /**
     * PathVariable 传参 url 传参
     * @param name
     * @return
     */
    @GetMapping("/productUrl/{name}")
    public String productUrl(@PathVariable("name") String name){
        log.info("进入商品服务");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        return "product : "+sdf.format(new Date())+"，当前端口为："+port+name;
    }

    @GetMapping("/productList")
    public String productList(){
        log.info("进入商品列表服务");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        return "productList : "+sdf.format(new Date())+"，当前端口为："+port;
    }

    @PostMapping("/saveProduct")
    public Product saveProduct(@RequestBody Product product){
        log.info("保存商品列表服务");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(product.toString());
        return product;
    }
}
