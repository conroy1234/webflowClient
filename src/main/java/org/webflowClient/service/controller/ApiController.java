package org.webflowClient.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webflowClient.service.config.WebClientConfig;

@RestController
public class ApiController {
    @Autowired
    WebClientConfig taskWebClientConfig;
    @GetMapping("/somedatavalue")
    public String getData(){

        String task = taskWebClientConfig.createWebClient()
                .get()
                .uri("data")
                .retrieve()
                .bodyToFlux(String.class).blockFirst();

        return task;
    }
}
