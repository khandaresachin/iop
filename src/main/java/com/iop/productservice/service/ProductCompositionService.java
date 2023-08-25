package com.iop.productservice.service;

import com.iop.productservice.dto.CompositionRequest;
import com.iop.productservice.dto.ProductCompositionUpdate;
import com.iop.productservice.dto.ResponseMessage;
import com.iop.productservice.entity.Component;
import com.iop.productservice.entity.Product;
import com.iop.productservice.entity.ProductComposition;
import com.iop.productservice.exception.ProductCompositionNotFoundException;
import com.iop.productservice.repository.ProductCompositionRepository;
import com.iop.productservice.util.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductCompositionService {
    Logger logger = LoggerFactory.getLogger(ProductCompositionService.class);
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
            composition.setCreateBy(AppConstant.USER_NAME_FOR_DB_AUDIT);
            composition.setCreatedAt(LocalDateTime.now());
            created = repository.save(composition);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseMessage> deleteComposition(Long compositionId) {
        getComposition(compositionId);
        repository.deleteById(compositionId);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage(AppConstant.PRODUCT_COMPOSITION_DELETED_SUCCESSFULLY);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    public ResponseEntity<ProductComposition> updateProductComposition(Long compositionId, ProductCompositionUpdate request) {
        logger.info("Update Product Composition request");
        ProductComposition productComposition = getComposition(compositionId);
        productComposition.setQuantity(request.getQuantity());
        productComposition.setEnabled(request.isEnabled());
        productComposition.setModifiedBy(AppConstant.USER_NAME_FOR_DB_AUDIT);
        productComposition.setModifiedAt(LocalDateTime.now());

        return new ResponseEntity<>(repository.save(productComposition), HttpStatus.ACCEPTED);
    }
}
