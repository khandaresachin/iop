package com.iop.productservice.exception;

import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class ComponentNotFoundException extends RuntimeException {
    Logger logger = (Logger) LoggerFactory.getLogger(ComponentNotFoundException.class);


    private static final long serialVersionUID = 1L;

    public ComponentNotFoundException(String message) {
        super(message);
    }
}
