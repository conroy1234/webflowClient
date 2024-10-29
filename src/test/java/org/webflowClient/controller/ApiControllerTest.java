package org.webflowClient.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.webflowClient.controller.data.TestData;
import org.webflowClient.dto.Product;
import org.webflowClient.dto.ProductDto;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiControllerTest {
    public static final String BASE_URL = "/product/";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ApiController apiController;

     @Test
    public void findByIdTest() throws Exception {

        Product product = new Product();
        product.setId(1);
        product.setName("T Shirt");
        product.setPrice(35.4);
        product.setQuantity(5);
        product.setTotalPrice(product.getPrice() * product.getQuantity());

        ResponseEntity<Product> responseEntity = ResponseEntity.ok(product);

        when(apiController.findById(anyInt())).thenReturn(responseEntity);
        mockMvc.perform(get(BASE_URL + "/" + 1)
                )
                .andDo(print())
                .andExpect(jsonPath("id").value("1"))
                .andExpect(jsonPath("name").value("T Shirt"))
                .andExpect(jsonPath("price").value("35.4"))
                .andExpect(jsonPath("quantity").value("5"))
                .andExpect(jsonPath("totalPrice").value("177.0")
                ).andExpect(status().isOk())
                .andReturn();
    }


    @Test
    public void findAllTest() throws Exception {
        TestData testData = new TestData();
        List<ProductDto> products = testData.getProducts();
        Mono<List<ProductDto>> mono = Mono.just(products);
        ResponseEntity<Mono<List<ProductDto>>>  responseEntity = ResponseEntity.ok(mono);

        when(apiController.findAll()).thenReturn(responseEntity);
        mockMvc.perform(get("/products" )
                )
                .andDo(print()).
                andExpect(status().isOk())
                .andReturn();
    }


}