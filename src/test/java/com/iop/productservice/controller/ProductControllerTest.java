package com.iop.productservice.controller;

import com.iop.productservice.entity.Product;
import com.iop.productservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;


@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductService productService;

    private final String URL = "/v1/products";


    @Test
    void getProductRequestTest() throws Exception {
        Long id = 100L;
        Product product = new Product(100L, "Cake", "cake for celebration", "/gifts/cakes",
                "cakes", null, true, false, "System", LocalDateTime.now(), null, null);

        Mockito.when(productService.getProduct(id)).thenReturn(product);

        mockMvc.perform(MockMvcRequestBuilders.get(URL + "/{productId}", id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(product.getProductId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productName").value(product.getProductName()));

    }
}
