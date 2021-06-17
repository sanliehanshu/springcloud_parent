package com.windsun.feignclient;

import com.windsun.entry.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
     * @return
     */
    @GetMapping("/productList")
    String productListss();

    @PostMapping("/saveProduct")
    Product saveProduct(@RequestBody Product product);
}
