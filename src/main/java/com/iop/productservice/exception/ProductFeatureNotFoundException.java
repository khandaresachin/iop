package com.iop.productservice.exception;

public class ProductFeatureNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ProductFeatureNotFoundException(String message) {
        super(message);
    }
}
