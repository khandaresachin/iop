package com.iop.productservice.service;

import com.iop.productservice.entity.ProductComposition;
import com.iop.productservice.exception.ProductCompositionNotFoundException;
import com.iop.productservice.repository.ProductCompositionRepository;
import com.iop.productservice.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCompositionService {

    private ProductCompositionRepository repository;

    @Autowired
    public ProductCompositionService(ProductCompositionRepository repository){
        this.repository = repository;
    }

    public ProductComposition getComposition(Long  compositionId){
        return repository.findById(compositionId)
                .orElseThrow(() -> new ProductCompositionNotFoundException(AppConstant.COMPOSITION_NOT_FOUND));
    }
}
