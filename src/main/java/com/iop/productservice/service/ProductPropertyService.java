package com.iop.productservice.service;

import com.iop.productservice.dto.ProductPropertyRequest;
import com.iop.productservice.dto.ResponseMessage;
import com.iop.productservice.entity.Product;
import com.iop.productservice.entity.ProductProperty;
import com.iop.productservice.exception.ProductPropertyNotFoundException;
import com.iop.productservice.repository.ProductPropertyRepository;
import com.iop.productservice.util.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class ProductPropertyService {
    Logger logger = LoggerFactory.getLogger(ProductPropertyService.class);

    private ProductPropertyRepository repository;

    private ProductService productService;

    @Autowired
    public ProductPropertyService(ProductPropertyRepository repository,
                                  ProductService productService) {
        this.repository = repository;
        this.productService = productService;
    }

    public ProductProperty getProductProperty(Long propertyId) {
        return repository.findById(propertyId)
                .orElseThrow(() ->
                        new ProductPropertyNotFoundException(AppConstant.PRODUCT_PROPERTY_NOT_FOUND));
    }

    public ResponseEntity<ProductProperty> createProductProperty(ProductPropertyRequest request) {
        logger.info("Create product property request");
        Product product = productService.getProduct(request.getProductId());

        ProductProperty productProperty = new ProductProperty();
        productProperty.setProduct(product);
        productProperty.setWidth(request.getWidth());
        productProperty.setWeight(request.getWeight());
        productProperty.setHeight(request.getHeight());
        productProperty.setMessageOnProduct(request.getMessageOnProduct());
        productProperty.setEnabled(true);
        productProperty.setSpecialHandleRequired(request.isSpecialHandleRequire());

        productProperty.setCreateBy(AppConstant.USER_NAME_FOR_DB_AUDIT);
        productProperty.setCreatedAt(LocalDateTime.now());

        return new ResponseEntity<>(repository.save(productProperty), HttpStatus.OK);
    }

    public ResponseEntity<ResponseMessage> deleteProductProperty(Long propertyId) {
        logger.info("Product property delete request");
        getProductProperty(propertyId);
        //Hard core delete implementation for product property
        repository.deleteById(propertyId);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage(AppConstant.PRODUCT_PROPERTY_DELETED_SUCCESSFULLY);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}
