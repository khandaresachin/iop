package com.iop.productservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductCompositionNotFoundException extends RuntimeException {
    Logger logger = LoggerFactory.getLogger(ProductCompositionNotFoundException.class);

    private static final long serialVersionUID = 1L;

    public ProductCompositionNotFoundException(String message) {
        super(message);
    }
}
