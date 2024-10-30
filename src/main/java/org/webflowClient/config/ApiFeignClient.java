package org.webflowClient.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.webflowClient.dto.ProductDto;

import java.util.List;

@FeignClient("WEB-SERVER-SERVICE")
public interface ApiFeignClient {

    @GetMapping("/api/products")
    public ResponseEntity<List<ProductDto>> findAllProducts();

    @GetMapping("/api/product/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable int id);
}
