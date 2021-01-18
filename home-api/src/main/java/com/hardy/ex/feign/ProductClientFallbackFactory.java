package com.hardy.ex.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 설명 :
 *
 * @author Hardy(조민국) / mingood92@gmail.com
 * @since 2021. 01. 18
 */
@Component
public class ProductClientFallbackFactory implements FallbackFactory<ProductClient> {

    @Override
    public ProductClient create(Throwable cause) {
        return new ProductClient() {
            @Override
            public String getProduct() {
                System.out.println("ERROR " + cause);
                return "Product Client Fallback " + cause.getCause();
            }
        };
    }

}
