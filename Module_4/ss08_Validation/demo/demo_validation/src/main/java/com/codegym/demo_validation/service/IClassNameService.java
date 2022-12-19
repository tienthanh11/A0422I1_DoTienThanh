package com.codegym.demo_validation.service;

import com.codegym.demo_validation.model.ClassName;

import java.util.List;

public interface IClassNameService {
    List<ClassName> findAll();

    void create(ClassName className);

    void update(ClassName className);

    void delete(String id);

    ClassName findById(String id);
}
