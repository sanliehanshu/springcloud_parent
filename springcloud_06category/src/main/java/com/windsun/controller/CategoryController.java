package com.windsun.controller;

import com.windsun.entry.Product;
import com.windsun.feignclient.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName : CategoryController
 * @Description :
 * @Author : ws
 * @Date: 2021-06-17 17:15
 * @Version 1.0
 */

/**
 * @RequestParam和@PathVariable
 *  相同点与区别
 *
 *  @RequestParam和@PathVariable都能够完成类似的功能——因为本质上，它们都是用户的输入，只不过输入的部分不同，一个在URL路径部分，
 *  另一个在参数部分。要访问一篇博客文章，这两种URL设计都是可以的：
 *
 * 通过@PathVariable，例如/blogs/1
 * 通过@RequestParam，例如blogs?blogId=1
 * 那么究竟应该选择哪一种呢？建议：
 *
 * 1、当URL指向的是某一具体业务资源（或资源列表），例如博客，用户时，使用@PathVariable
 *
 * 2、当URL需要对资源或者资源列表进行过滤，筛选时，用@RequestParam
 *
 * 例如我们会这样设计URL：
 *
 * /blogs/{blogId}
 * /blogs?state=publish而不是/blogs/state/publish来表示处于发布状态的博客文章
 * 更多用法
 *
 *  一旦我们在方法中定义了@RequestParam变量，如果访问的URL中不带有相应的参数，就会抛出异常——这是显然的，
 *  Spring尝试帮我们进行绑定，然而没有成功。但有的时候，参数确实不一定永远都存在，这时我们可以通过定义required属性：
 *
 * @RequestParam(value = "id", required = false)
 * 当然，在参数不存在的情况下，可能希望变量有一个默认值：
 *
 * @RequestParam(value = "id", required = false, defaultValue = "0")
 */
@RestController
public class CategoryController {


    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Value("${server.port}")
    private int port;

    @Autowired
    private ProductClient productClient;

    /**
     * RequestParam
     * @param name
     * @return
     */
    @GetMapping("/category")
    public String categoryName(@RequestParam("name") String name) {
        log.info("进入类别服务");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String product = productClient.product();
        System.out.println(sdf.format(new Date()));
        String productList = productClient.productListss();
        String str = productClient.product(name);
        log.info("name {}" + str);

        return "category : " + sdf.format(new Date()) + "，当前端口为：" + port + "，请求结果：" + product + productList + str;
    }


    /**
     * PathVariable /categorys/{name}
     * @param name
     * @return
     */
    @GetMapping("/categorys/{name}")
    public String category(@PathVariable("name") String name) {
        log.info("进入类别服务");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String lisi = productClient.productUrl(name);
        log.info("productUrl {}" + name);

        return "category : " + sdf.format(new Date()) + "，当前端口为：" + port + "，请求结果：" + lisi;
    }

    /**
     * post
     * @param products
     * @return
     */
    @PostMapping("/categoryPro")
    public Product categoryPro(@RequestBody Product products) {
        log.info("进入类别服务" + products);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String product = productClient.product();
        System.out.println(sdf.format(new Date()));
        String productList = productClient.productListss();
//        products.setTime(new Date());
        Product s = productClient.saveProduct(products);
        return s;
    }
}
