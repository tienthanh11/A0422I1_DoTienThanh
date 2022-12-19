package com.codegym.demo_validation.config;

import com.codegym.demo_validation.formatter.DateFomatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFomatter());
//        registry.addConverter(new DateConverter());
    }
}
