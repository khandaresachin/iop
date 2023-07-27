package com.iop.productservice.controller;

import com.iop.productservice.dto.ProductRequest;
import com.iop.productservice.dto.ProductUpdateRequest;
import com.iop.productservice.dto.ResponseMessage;
import com.iop.productservice.entity.Product;
import com.iop.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * API to fetch single product with productId as path variable
     *
     * @param productId unique id for product
     * @return Product details in case of product exists or else throws
     * ProductNotFoundException
     */
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Long productId) {
        Product product = productService.getProduct(productId);
        if (product == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /**
     * API to create the product having product request as a request body
     *
     * @param productRequest consists the minimum request parameters for create product
     * @return the created product details along with products unique id or else
     * returns BAD Request
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(
            @RequestBody @Valid ProductRequest productRequest
    ) {
        return productService.createProduct(productRequest);
    }

    /**
     * API to update/patch the product with partial update to existing products information
     * @param productId unique product id for updating the details of product
     * @param updateRequest the request consist of fields which needs to be updated
     * @return updated product information along with HTTP Status code
     */
    @PatchMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId,
                                                 @RequestBody ProductUpdateRequest updateRequest)
    {
        return productService.updateProduct(productId, updateRequest);
    }

    /**
     * API to soft delete the product from DB, it is using isDeleted flag for soft delete
     *
     * @param productId unique product id for delete product
     * @return success message if product exists for delete otherwise throws
     * ProductNotFoundException
     */
    @DeleteMapping("/{productId}")
    public ResponseEntity<ResponseMessage> deleteProduct(
            @PathVariable Long productId) {
        return productService.deleteProduct(productId);
    }


}