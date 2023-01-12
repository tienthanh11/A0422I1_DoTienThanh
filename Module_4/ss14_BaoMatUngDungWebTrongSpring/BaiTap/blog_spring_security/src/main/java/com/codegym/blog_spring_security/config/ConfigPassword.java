package com.codegym.blog_spring_security.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ConfigPassword {

    // mã hoá mặt khẩu
    public static String generatePassword(String rawPass) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(rawPass);
    }

    public static void main(String[] args) {
        System.out.println(generatePassword("123456"));
    }
}
