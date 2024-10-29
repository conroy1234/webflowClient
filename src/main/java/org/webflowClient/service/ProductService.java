package org.webflowClient.service;

import org.springframework.stereotype.Service;
import org.webflowClient.dto.Product;
import org.webflowClient.dto.ProductDto;

@Service
public class ProductService {
    public Product getProduct(ProductDto productDto){
        return  Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .totalPrice(productDto.getQuantity() * productDto.getPrice())
                .build();
    }
}
