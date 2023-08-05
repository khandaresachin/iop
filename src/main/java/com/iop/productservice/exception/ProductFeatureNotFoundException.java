package com.iop.productservice.exception;

import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class ProductFeatureNotFoundException extends RuntimeException {
    Logger logger = (Logger) LoggerFactory.getLogger(ProductFeatureNotFoundException.class);
    private static final long serialVersionUID = 1L;

    public ProductFeatureNotFoundException(String message) {
        super(message);
    }
}
