package com.iop.productservice.service;

import com.iop.productservice.dto.ProductFeatureRequest;
import com.iop.productservice.dto.ProductFeatureUpdate;
import com.iop.productservice.dto.ResponseMessage;
import com.iop.productservice.entity.Product;
import com.iop.productservice.entity.ProductFeature;
import com.iop.productservice.exception.ProductFeatureNotFoundException;
import com.iop.productservice.repository.ProductFeatureRepository;
import com.iop.productservice.util.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductFeatureService {
    Logger logger = LoggerFactory.getLogger(ProductFeatureService.class);

    private ProductFeatureRepository repository;

    private ProductService productService;

    @Autowired
    public ProductFeatureService(ProductFeatureRepository repository,
                                 ProductService productService) {
        this.repository = repository;
        this.productService = productService;
    }

    public ProductFeature getProductFeature(Long id) {
        logger.info("Get product feature request for id :{}", id);
        return repository.findById(id)
                .orElseThrow(() -> new ProductFeatureNotFoundException(AppConstant.PRODUCT_FEATURE_NOT_FOUND));
    }

    public ResponseEntity<ProductFeature> createProductFeature(ProductFeatureRequest request) {
        logger.info("Create product feature request");
        Product product = productService.getProduct(request.getProductId());
        ProductFeature productFeature = new ProductFeature();
        productFeature.setProduct(product);
        productFeature.setSize(request.getSize());
        productFeature.setColor(request.getColor());
        productFeature.setEnabled(true);
        productFeature.setCreateBy(AppConstant.USER_NAME_FOR_DB_AUDIT);
        productFeature.setCreatedAt(LocalDateTime.now());
        return new ResponseEntity<>(repository.save(productFeature), HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseMessage> deleteProductFeature(Long productFeatureId) {
        logger.info("Delete request for product feature");
        getProductFeature(productFeatureId);
        //Hard core delete implementation for product feature
        repository.deleteById(productFeatureId);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage(AppConstant.PRODUCT_FEATURE_DELETED_SUCCESSFULLY);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    public ResponseEntity<ProductFeature> updateProductFeature(Long productFeatureId, ProductFeatureUpdate request) {
        logger.info("Product feature update request");
        ProductFeature productFeature = getProductFeature(productFeatureId);
        productFeature.setColor(request.getColor());
        productFeature.setSize(request.getSize());
        productFeature.setEnabled(request.isEnabled());
        productFeature.setModifiedBy(AppConstant.USER_NAME_FOR_DB_AUDIT);
        productFeature.setModifiedAt(LocalDateTime.now());

        return new ResponseEntity<>(repository.save(productFeature), HttpStatus.ACCEPTED);
    }
}
