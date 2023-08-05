package com.iop.productservice.controller;

import com.iop.productservice.entity.ProductProperty;
import com.iop.productservice.service.ProductPropertyService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/v1/products/properties")
public class ProductPropertyController {
    Logger logger = (Logger) LoggerFactory.getLogger(ProductPropertyController.class);

    private ProductPropertyService service;

    @Autowired
    public ProductPropertyController(ProductPropertyService service) {
        this.service = service;
    }

    @GetMapping("/{propertyId}")
    public ResponseEntity<ProductProperty> getProductProperty(

            @PathVariable Long propertyId) {

        ProductProperty productProperty = service.getProductProperty(propertyId);
        return new ResponseEntity<>(productProperty, HttpStatus.OK);
    }
}
