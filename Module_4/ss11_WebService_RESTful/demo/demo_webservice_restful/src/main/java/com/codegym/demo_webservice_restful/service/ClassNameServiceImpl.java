package com.codegym.demo_webservice_restful.service;

import com.codegym.demo_webservice_restful.entity.ClassName;
import com.codegym.demo_webservice_restful.repository.ClassNameRepository;
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
