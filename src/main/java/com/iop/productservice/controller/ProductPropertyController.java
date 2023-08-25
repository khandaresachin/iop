package com.iop.productservice.controller;

import com.iop.productservice.dto.ProductPropertyRequest;
import com.iop.productservice.dto.ProductPropertyUpdate;
import com.iop.productservice.dto.ResponseMessage;
import com.iop.productservice.entity.ProductProperty;
import com.iop.productservice.service.ProductPropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/products/properties")
public class ProductPropertyController {
    Logger logger = LoggerFactory.getLogger(ProductPropertyController.class);

    private ProductPropertyService service;

    @Autowired
    public ProductPropertyController(ProductPropertyService service) {
        this.service = service;
    }

    /**
     * This API is used to get product property details
     *
     * @param propertyId unique id for product property
     * @return product property details with HttpStatus
     */
    @GetMapping("/{propertyId}")
    public ResponseEntity<ProductProperty> getProductProperty(

            @PathVariable Long propertyId) {

        ProductProperty productProperty = service.getProductProperty(propertyId);
        return new ResponseEntity<>(productProperty, HttpStatus.OK);
    }

    /**
     * Create product property
     *
     * @param request create product property
     * @return created product property
     */
    @PostMapping
    public ResponseEntity<ProductProperty> createProductProperty(
            @RequestBody ProductPropertyRequest request
    ) {
        logger.info("request to create product property ");
        return service.createProductProperty(request);
    }

    /**
     * Update product property
     *
     * @param propertyId unique id for product property
     * @param request    update product property
     * @return updated product property
     */
    @PutMapping("/{propertyId}")
    public ResponseEntity<ProductProperty> updateProductProperty(
            @PathVariable Long propertyId,
            @RequestBody ProductPropertyUpdate request
    ) {
        logger.info("Product property update request for id :{}", propertyId);
        return service.updateProductProperty(propertyId, request);
    }

    /**
     * Delete product property
     *
     * @param propertyId unique id for product property
     * @return Response message after delete
     */
    @DeleteMapping("/{propertyId}")
    public ResponseEntity<ResponseMessage> deleteProductProperty(
            @PathVariable Long propertyId
    ) {
        logger.info("Request to delete product property fot id :{}", propertyId);
        return service.deleteProductProperty(propertyId);
    }

}
