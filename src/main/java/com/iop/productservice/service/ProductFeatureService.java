package com.iop.productservice.service;

import com.iop.productservice.entity.ProductFeature;
import com.iop.productservice.repository.ProductFeatureRepository;
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
        Optional<ProductFeature> featureOptional = repository.findById(id);
        return featureOptional.get();
    }
}
