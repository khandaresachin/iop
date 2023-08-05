package com.iop.productservice.exception;

import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class ProductPropertyNotFoundException extends RuntimeException {
    Logger logger = (Logger) LoggerFactory.getLogger(ProductPropertyNotFoundException.class);
    private static final long serialVersionUID = 1L;

    public ProductPropertyNotFoundException(String message) {
        super(message);
    }
}
