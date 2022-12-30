package com.codegym.demo_session_cookie.service.impl;

import com.codegym.demo_session_cookie.model.ClassName;
import com.codegym.demo_session_cookie.repository.IClassNameRepository;
import com.codegym.demo_session_cookie.service.IClassNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassNameServiceImpl implements IClassNameService {

    @Autowired
    IClassNameRepository classNameRepository;

    @Override
    public List<ClassName> findAll() {
        return classNameRepository.findAll();
    }

    @Override
    public void create(ClassName className) {
        classNameRepository.save(className);
    }

    @Override
    public void update(ClassName className) {
        classNameRepository.save(className);
    }

    @Override
    public void delete(String id) {
        classNameRepository.deleteById(id);
    }

    @Override
    public ClassName findById(String id) {
        return classNameRepository.findById(id).orElse(null);
    }
}
