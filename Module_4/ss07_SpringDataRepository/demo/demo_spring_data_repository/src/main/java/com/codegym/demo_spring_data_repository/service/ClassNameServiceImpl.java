package com.codegym.demo_spring_data_repository.service;

import com.codegym.demo_spring_data_repository.entity.ClassName;
import com.codegym.demo_spring_data_repository.repository.ClassNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassNameServiceImpl implements ClassNameService {

    @Autowired
    ClassNameRepository repository;

    @Override
    public void create(ClassName className) {
        repository.save(className);
    }

    @Override
    public void update(ClassName className) {
        repository.save(className);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<ClassName> findAll() {
        return repository.findAll();
    }

    @Override
    public ClassName findById(String id) {
        return repository.findById(id).orElse(null);
    }
}
