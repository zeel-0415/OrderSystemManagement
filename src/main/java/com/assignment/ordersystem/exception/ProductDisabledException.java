package com.assignment.ordersystem.exception;

public class ProductDisabledException extends RuntimeException {

    public ProductDisabledException(String message){
        super(message);
    }
}
