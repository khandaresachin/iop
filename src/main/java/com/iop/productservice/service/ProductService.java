package com.iop.productservice.service;

import com.iop.productservice.dto.ProductRequest;
import com.iop.productservice.dto.ProductUpdateRequest;
import com.iop.productservice.dto.ResponseMessage;
import com.iop.productservice.entity.Product;
import com.iop.productservice.exception.ProductNotFoundException;
import com.iop.productservice.repository.ProductRepository;
import com.iop.productservice.util.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct(Integer productId) {
        return productRepository.findByProductIdAndIsDeleted(productId, false)
                .orElseThrow(() -> new ProductNotFoundException(AppConstant.PRODUCT_NOT_FOUND_MSG));
    }

    public ResponseEntity<Product> createProduct(ProductRequest productRequest) {
        Product created;
        try {
            Product product = new Product();
            product.setProductName(productRequest.getProductName());
            product.setProductUrl(productRequest.getProductUrl());
            product.setProductDescription(productRequest.getProductDescription());
            product.setProductType(productRequest.getProductType());
            product.setProductSubType(productRequest.getProductSubType());
            product.setEnabled(true);
            product.setCreateBy(AppConstant.USER_NAME_FOR_DB_AUDIT);
            product.setCreatedAt(LocalDateTime.now());

            created = productRepository.save(product);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseMessage> deleteProduct(Integer productId) {
        Product productExist = getProduct(productId);
        productExist.setDeleted(true);
        productExist.setEnabled(false);
        productRepository.save(productExist);
        ResponseMessage message = new ResponseMessage();
        message.setMessage(AppConstant.PRODUCT_DELETED_MSG);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    public ResponseEntity<Product> updateProduct(Integer productId, ProductUpdateRequest updateRequest) {
        Optional<Product> existingProduct = productRepository.findById(productId);
        if (existingProduct.isEmpty()){
            throw new ProductNotFoundException(AppConstant.PRODUCT_NOT_FOUND_MSG);
        }
        Product updateProduct = existingProduct.get();
        if(updateRequest.getProductName() != null){
            updateProduct.setProductName(updateRequest.getProductName());
        }
        if(updateRequest.getProductDescription() != null){
            updateProduct.setProductDescription(updateRequest.getProductDescription());
        }
        if(updateRequest.getProductUrl() != null){
            updateProduct.setProductUrl(updateRequest.getProductUrl());
        }
        if(updateRequest.getProductType() != null){
            updateProduct.setProductType(updateRequest.getProductType());
        }
        if(updateRequest.getProductSubType() != null){
            updateProduct.setProductSubType(updateRequest.getProductSubType());
        }

        if(updateProduct.isDeleted()){
            updateProduct.setDeleted(updateRequest.isDeleted());
        }

        productRepository.save(updateProduct);
        return new ResponseEntity<>(updateProduct, HttpStatus.ACCEPTED);
    }
}
