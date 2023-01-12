package com.codegym.blog_spring_security.error;

public class LoginBeforeAction extends Exception {
    public LoginBeforeAction(String error) {
        super(error);
    }
}
