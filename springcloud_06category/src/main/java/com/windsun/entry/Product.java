package com.windsun.entry;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 项目名称：springcloud_parent
 * 类 名 称：Product
 * 类 描 述：
 * 创建时间：2021/6/17 21:08
 * 创 建 人：wangsheng
 */
@Data
public class Product {

    private Long id;
    private String name;
    private Double price;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;


}
