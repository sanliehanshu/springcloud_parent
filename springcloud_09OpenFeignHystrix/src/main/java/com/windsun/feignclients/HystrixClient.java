package com.windsun.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName : HystrixClient
 * @Description :
 * @Author : ws
 * @Date: 2021-06-18 21:17
 * @Version 1.0
 */
@FeignClient(value = "HYSTRIX",fallback = HystrixClientFallBack.class)
public interface HystrixClient {

    @RequestMapping("/hystrix")
    String test(@RequestParam("id") Integer id);
}
