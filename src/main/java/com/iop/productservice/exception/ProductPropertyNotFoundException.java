package com.iop.productservice.exception;

public class ProductPropertyNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ProductPropertyNotFoundException(String message) {
        super(message);
    }
}
