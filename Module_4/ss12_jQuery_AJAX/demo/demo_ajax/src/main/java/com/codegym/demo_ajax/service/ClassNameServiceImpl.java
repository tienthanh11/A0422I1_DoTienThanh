package com.codegym.demo_ajax.service;

import com.codegym.demo_ajax.entity.ClassName;
import com.codegym.demo_ajax.repository.ClassNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassNameServiceImpl implements ClassNameService {

    @Autowired
    ClassNameRepository classNameRepository;

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
    public List<ClassName> findAll() {
        return classNameRepository.findAll();
    }

    @Override
    public ClassName findById(String id) {
        return classNameRepository.findById(id).orElse(null);
    }
}
