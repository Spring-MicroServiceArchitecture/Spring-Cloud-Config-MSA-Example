package com.hardy.ex.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 설명 :
 *
 * @author Hardy(조민국) / mingood92@gmail.com
 * @since 2021. 01. 18
 */
@RefreshScope
@RestController
@RequestMapping("product")
public class ProductController {

    @Value("${test.value}")
    private String testValue;

    @GetMapping("/ping")
    public String getProduct() {
        System.out.println("## PRODUCT");
//        try {
//            Thread.sleep(13000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "Product API";
    }

    @GetMapping("/value")
    public String getTestValue() {
        return testValue;
    }

}
