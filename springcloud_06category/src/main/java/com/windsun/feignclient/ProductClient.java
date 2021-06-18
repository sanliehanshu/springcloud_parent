package com.windsun.feignclient;

import com.windsun.entry.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName : ProductClient
 * @Description : 调用商品服务接口
 * @Author : ws
 * @Date: 2021-06-17 17:26
 * @Version 1.0
 */
@FeignClient("PRODUCT")
public interface ProductClient {

    @GetMapping("/product")
    String product();

    /**
     * 注意：只需跟调用接口返回值、形参、url一致即可，方法名可以不一致
     *
     * @return
     */
    @GetMapping("/productList")
    String productListss();

    @PostMapping("/saveProduct")
    Product saveProduct(@RequestBody Product product);

    @GetMapping("/productName")
    String product(@RequestParam("name") String name);

    @GetMapping("/productUrl/{name}")
    String productUrl(@PathVariable("name") String name);
}
