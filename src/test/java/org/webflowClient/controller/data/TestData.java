package org.webflowClient.controller.data;

import org.webflowClient.dto.Product;
import org.webflowClient.dto.ProductDto;

import java.util.List;

public class TestData {

    public List<ProductDto> getProducts(){
        List<ProductDto> products = List.of(ProductDto.builder()
                        .id(1)
                        .name("T shirt")
                        .price(20.3)
                        .quantity(2)
                        .build(),
                ProductDto.builder()
                        .id(2)
                        .name("Denim Jeans Pants")
                        .price(54.3)
                        .quantity(4)
                        .build(),
                ProductDto.builder()
                        .id(3)
                        .name("perfume")
                        .price(100)
                        .quantity(1)
                        .build()

        );

        return products;

    }
}
