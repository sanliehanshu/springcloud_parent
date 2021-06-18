package com.windsun.feignclients;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName : HystrixClientFallBack
 * @Description : 服务调用方的服务熔断器，当调用的服务宕机时才会调用此服务
 * @Author : ws
 * @Date: 2021-06-18 21:15
 * @Version 1.0
 */
@Component
public class HystrixClientFallBack implements HystrixClient{
    @Override
    public String test(@RequestParam("id") Integer id) {
        return "HystrixClientFallBack 熔断器";
    }
}
