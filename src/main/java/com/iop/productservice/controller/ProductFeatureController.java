package com.iop.productservice.controller;

import com.iop.productservice.dto.ProductFeatureRequest;
import com.iop.productservice.entity.ProductFeature;
import com.iop.productservice.service.ProductFeatureService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/products/features")
public class ProductFeatureController {
    Logger logger = LoggerFactory.getLogger(ProductFeatureController.class);
    private ProductFeatureService service;

    @Autowired
    public ProductFeatureController(ProductFeatureService service) {
        this.service = service;
    }

    /**
     * This API is used to get product feature
     *
     * @param productFeatureId unique id for product feature
     * @return product feature details with HttpStatus
     */
    @GetMapping("/{productFeatureId}")
    public ResponseEntity<ProductFeature> getProductFeature(
            @PathVariable Long productFeatureId) {
        logger.info("Delete request for productFeatureId :{} ",productFeatureId);
        ProductFeature productFeature = service.getProductFeature(productFeatureId);
        return new ResponseEntity<>(productFeature, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductFeature> createProductFeature(
            @RequestBody ProductFeatureRequest request
            ){
        return service.createProductFeature(request);
    }
}
