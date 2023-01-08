package com.codegym.phone_manager.error.phone;

public class NotFoundById extends Exception {
    public NotFoundById(String errorLine) {
        super(errorLine);
    }
}
