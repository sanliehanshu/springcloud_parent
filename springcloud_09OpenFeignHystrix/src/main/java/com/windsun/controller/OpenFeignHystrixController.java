package com.windsun.controller;

import com.windsun.feignclients.HystrixClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : OpenFeignHystrixController
 * @Description :
 * @Author : ws
 * @Date: 2021-06-18 21:01
 * @Version 1.0
 */
@RestController
@Slf4j
public class OpenFeignHystrixController {

    @Autowired
    private HystrixClient hystrixClient;

    @RequestMapping("/test")
    public String openFeignHystrix(@RequestParam("id") Integer id){
        log.info("openFeignHystrix：{}  id：{}","ddd",id);
        String test = hystrixClient.test(id);
        System.out.println("调用hystrix返回结果："+test);
        return "openFeignHystrix ok！id："+id;
    }
}
