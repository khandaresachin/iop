package com.iop.productservice.exception;

import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class ProductNotFoundException extends RuntimeException {
    Logger logger = (Logger) LoggerFactory.getLogger(ProductNotFoundException.class);

    private static final long serialVersionUID = 1L;

    public ProductNotFoundException(String message) {
        super(message);
    }
}
