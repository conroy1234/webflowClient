package org.webflowClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.webflowClient.dto.Product;
import org.webflowClient.dto.ProductDto;
import org.webflowClient.config.WebClientConfig;
import org.webflowClient.service.ProductService;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    WebClientConfig taskWebClientConfig;

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Mono<List<ProductDto>>> findAll(){

        Mono<List<ProductDto>>  productDtos = taskWebClientConfig.createWebClient()
                .get()
                .uri("/products")
                .retrieve()
                .bodyToFlux( ProductDto.class).collectList();

        return ResponseEntity.ok(productDtos);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> findById(@PathVariable int id){
        ProductDto productDto = taskWebClientConfig.createWebClient()
                .get()
                .uri("/product/"+id)
                .retrieve()
                .bodyToFlux( ProductDto.class).blockFirst();
        Product product = productService.getProduct(productDto);

        return  ResponseEntity.ok(product);
    }

}
