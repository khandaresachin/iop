package com.iop.productservice.service;

import com.iop.productservice.dto.CompositionRequest;
import com.iop.productservice.entity.Component;
import com.iop.productservice.entity.Product;
import com.iop.productservice.entity.ProductComposition;
import com.iop.productservice.exception.ProductCompositionNotFoundException;
import com.iop.productservice.repository.ProductCompositionRepository;
import com.iop.productservice.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductCompositionService {

    private ProductCompositionRepository repository;
    private ProductService productService;
    private ComponentService componentService;

    @Autowired
    public ProductCompositionService(ProductCompositionRepository repository,
                                     ProductService productService,
                                     ComponentService componentService) {
        this.repository = repository;
        this.productService = productService;
        this.componentService = componentService;
    }

    public ProductComposition getComposition(Long compositionId) {
        return repository.findById(compositionId)
                .orElseThrow(() -> new ProductCompositionNotFoundException(AppConstant.COMPOSITION_NOT_FOUND));
    }

    public ResponseEntity<ProductComposition> createComposition(CompositionRequest request) {
        ProductComposition created = new ProductComposition();
        try {
            ProductComposition composition = new ProductComposition();
            //Validation for provided data
            Product product = productService.getProduct(request.getProductId());
            Component component = componentService.getComponent(request.getComponentId());
            composition.setProduct(product);
            composition.setComponent(component);
            composition.setQuantity(request.getQuantity());
            composition.setEnabled(request.getIsEnabled());
            created = repository.save(composition);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
