package org.webflowClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.webflowClient.config.ApiFeignClient;
import org.webflowClient.dto.ProductDto;

import java.util.List;

@RestController
public class ApiFeignController {

    @Autowired
    ApiFeignClient apiFeignClient;

    @GetMapping("/api/products")
    public ResponseEntity<List<ProductDto>> findAllProducts(){
        return apiFeignClient.findAllProducts();
    }

    @GetMapping("/api/product/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable int id){
        return apiFeignClient.findById(id);
    }
}
