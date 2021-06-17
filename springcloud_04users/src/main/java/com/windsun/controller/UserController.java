package com.windsun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName : UserController
 * @Description :
 * @Author : ws
 * @Date: 2021-06-16 17:00
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/listUser")
    public String listUser(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        String url = "http://localhost:9999/api/order/listOrder";
        /*String forObject = restTemplate.getForObject(url, String.class);/List<ServiceInstance> service = discoveryClient.getInstances("ORDERS");
        // 第一种：discoveryClient
        String forObject = restTemplate.getForObject(service.get(0).getUri()+"/api/order/listOrder", String.class);*/
        // 第二种：loadBalancerClient 默认轮巡 顶级接口是IRule
       /* ServiceInstance serviceInstance = loadBalancerClient.choose("ORDERS");
        String forObject = restTemplate.getForObject(serviceInstance.getUri()+"/api/order/listOrder", String.class);*/
        // 第三种：@LoadBalanced 让对象具有负载均衡特性
        String forObject = restTemplate.getForObject("http://ORDERS/api/order/listOrder", String.class);
        return "user : "+sdf.format(new Date())+"，调用order返回结果："+forObject;

    }
}
