package com.codegym.demo_session_cookie.service;

import com.codegym.demo_session_cookie.model.ClassName;

import java.util.List;

public interface IClassNameService {
    List<ClassName> findAll();

    void create(ClassName className);

    void update(ClassName className);

    void delete(String id);

    ClassName findById(String id);
}
