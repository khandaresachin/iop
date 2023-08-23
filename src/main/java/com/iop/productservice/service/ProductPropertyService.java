package com.iop.productservice.service;

import com.iop.productservice.entity.ProductProperty;
import com.iop.productservice.exception.ProductPropertyNotFoundException;
import com.iop.productservice.repository.ProductPropertyRepository;
import com.iop.productservice.util.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductPropertyService {
    Logger logger = LoggerFactory.getLogger(ProductPropertyService.class);
    private ProductPropertyRepository repository;

    @Autowired
    public ProductPropertyService(ProductPropertyRepository repository) {
        this.repository = repository;
    }

    public ProductProperty getProductProperty(Long propertyId) {
        return repository.findById(propertyId)
                .orElseThrow(() ->
                        new ProductPropertyNotFoundException(AppConstant.PRODUCT_PROPERTY_NOT_FOUND));
    }
}
