package org.webflowClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WebflowClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebflowClientApplication.class, args);
    }
}
