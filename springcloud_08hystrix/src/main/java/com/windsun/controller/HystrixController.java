package com.windsun.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @ClassName : HystrixController
 * @Description :  @HystrixCommand(fallbackMethod = "testFallBack") 添加熔断之后的快速响应，熔断方法返回值，形参必须一致
 *                 当10秒20个请求失败；当10秒一般请求失败会触发熔断；
 *                 当配置了自定义的熔断和通用的熔断，自定义的fallbackMethod高于通用的defaultFallback
 *                 defaultFallback 必须和方法的返回值和形参一致
 * @Author : ws
 * @Date: 2021-06-18 16:50
 * @Version 1.0
 */
@RestController
@Slf4j
public class HystrixController {

    @RequestMapping("/hystrix")
    @HystrixCommand(fallbackMethod = "testFallBack",defaultFallback = "defaultFallBack")
    public String test(Integer id){
        log.info("id:{}"+id);
        if (id <= 0) {
            throw new RuntimeException("id不合法！");
        }
        return "ok!，id为："+id;
    }

    public String testFallBack(Integer id){
        return "当前活动过于火爆，服务已经被熔断了，"+id;
    }

    public Object testFallBackObj(Integer id){
        ArrayList<String> objects = new ArrayList<>();
        objects.add("zs");
        objects.add("ls");

        return "Object,当前活动过于火爆，服务已经被熔断了，"+objects.get(0)+objects.get(1);
    }

    public String defaultFallBack(){
        return "这是默认的熔断方法！";
    }

    @RequestMapping("/hystrixObj")
    @HystrixCommand(fallbackMethod = "testFallBackObj")
    public Object tests(Integer id){
        log.info("id:{}"+id);
        if (id <= 0) {
            throw new RuntimeException("id不合法！");
        }
        return "ok!，id为："+id;
    }
}
