package com.iop.productservice.exception;

public class ComponentNotFoundException extends RuntimeException{

    private static final long serialVersionUID =1L;

    public ComponentNotFoundException(String message){
        super(message);
    }
}
