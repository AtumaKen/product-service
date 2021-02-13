package com.kenoly.productservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kenoly.productservice.web.model.ProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    private static final String url = "/api/v1/product/";

    @Test
    void getProductById() throws Exception {
        mockMvc.perform(get( url + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewProduct() throws Exception {
        ProductDto productDto = ProductDto.builder().build();
        String productToJson = objectMapper.writeValueAsString(productDto);

        mockMvc.perform(post(url)
        .contentType(MediaType.APPLICATION_JSON)
        .content(productToJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateProductById() throws Exception {
        ProductDto productDto = ProductDto.builder().build();
        String productToJson = objectMapper.writeValueAsString(productDto);

        mockMvc.perform(put(url + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(productToJson))
                .andExpect(status().isNoContent());
    }
}