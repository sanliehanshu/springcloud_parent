package com.windsun.controller;

import com.windsun.feignclient.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName : CategoryController
 * @Description :
 * @Author : ws
 * @Date: 2021-06-17 17:15
 * @Version 1.0
 */
@RestController
public class CategoryController {


    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Value("${server.port}")
    private int port;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/category")
    public String category(){
        log.info("进入类别服务");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String product = productClient.product();
        System.out.println(sdf.format(new Date()));
        String productList = productClient.productListss();
        return "category : "+sdf.format(new Date())+"，当前端口为："+port+"，请求结果："+product+productList;
    }
}
