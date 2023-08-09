package com.iop.productservice.service;

import com.iop.productservice.dto.ProductFeatureRequest;
import com.iop.productservice.entity.ProductFeature;
import com.iop.productservice.exception.ProductFeatureNotFoundException;
import com.iop.productservice.repository.ProductFeatureRepository;
import com.iop.productservice.util.AppConstant;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ProductFeatureService {
    Logger logger = (Logger) LoggerFactory.getLogger(ProductFeatureService.class);

    private ProductFeatureRepository repository;

    @Autowired
    public ProductFeatureService(ProductFeatureRepository repository) {
        this.repository = repository;
    }

    public ProductFeature getProductFeature(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductFeatureNotFoundException(AppConstant.PRODUCT_FEATURE_NOT_FOUND));
    }

    public ResponseEntity<ProductFeature> createProductFeature(ProductFeatureRequest request) {
        return null;
    }
}
