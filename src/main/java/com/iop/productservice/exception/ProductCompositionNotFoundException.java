package com.iop.productservice.exception;

public class ProductCompositionNotFoundException extends RuntimeException {


    private static final long serialVersionUID = 1L;

    public ProductCompositionNotFoundException(String message) {
        super(message);
    }
}
