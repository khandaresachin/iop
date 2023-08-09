package com.iop.productservice.controller;

import com.iop.productservice.dto.CompositionRequest;
import com.iop.productservice.entity.ProductComposition;
import com.iop.productservice.service.ProductCompositionService;
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
@RequestMapping("/v1/products/compositions")
public class ProductCompositionController {
    Logger logger = LoggerFactory.getLogger(ProductCompositionController.class);

    private ProductCompositionService service;

    @Autowired
    public ProductCompositionController(ProductCompositionService service) {
        this.service = service;
    }

    /**
     * This API is used to get product composition
     *
     * @param compositionId unique id for product composition
     * @return product composition with HttpStatus
     */
    @GetMapping("/{compositionId}")
    public ResponseEntity<ProductComposition> getProductComposition(
            @PathVariable Long compositionId) {
        ProductComposition composition = service.getComposition(compositionId);
        return new ResponseEntity<>(composition, HttpStatus.OK);
    }

    /**
     * This API is used to create composition
     *
     * @param request create composition request
     * @return product composition with HttpStatus
     */
    @PostMapping
    public ResponseEntity<ProductComposition> createComposition(
            @RequestBody CompositionRequest request
    ) {
        logger.info("create composition  request : {} ", request);
        return service.createComposition(request);
    }
}
