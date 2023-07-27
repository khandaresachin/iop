package com.iop.productservice.service;

import com.iop.productservice.entity.ProductFeature;
import com.iop.productservice.exception.ProductFeatureNotFoundException;
import com.iop.productservice.repository.ProductFeatureRepository;
import com.iop.productservice.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductFeatureService {

    private ProductFeatureRepository repository;

    @Autowired
    public ProductFeatureService(ProductFeatureRepository repository){
        this.repository = repository;
    }

    public ProductFeature getProductFeature(Long id){
       return repository.findById(id)
               .orElseThrow(() -> new ProductFeatureNotFoundException(AppConstant.PRODUCT_FEATURE_NOT_FOUND));
    }
}
