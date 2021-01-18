package com.hardy.ex.controller;

import com.hardy.ex.feign.ProductClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 설명 :
 *
 * @author Hardy(조민국) / mingood92@gmail.com
 * @since 2021. 01. 18
 */
@RestController
@RequestMapping("home")
public class HomeController {

    private final ProductClient productClient;

    public HomeController(ProductClient productClient) {
        this.productClient = productClient;
    }

    @GetMapping("/product")
    public String getProduct() {
        System.out.println("## HOME");
        return productClient.getProduct();
    }

}
