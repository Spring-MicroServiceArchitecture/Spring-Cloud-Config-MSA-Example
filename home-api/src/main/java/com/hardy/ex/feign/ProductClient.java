package com.hardy.ex.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 설명 :
 *
 * @author Hardy(조민국) / mingood92@gmail.com
 * @since 2021. 01. 18
 */
@FeignClient(value = "product-api", fallbackFactory = ProductClientFallbackFactory.class)
public interface ProductClient {

    @GetMapping("product/ping")
    String getProduct();

}
