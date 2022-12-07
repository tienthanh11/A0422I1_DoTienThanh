package com.codegym.service;

import com.codegym.bean.Student;
import com.codegym.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void createOrUpdate(Student s) {
        studentRepository.createOrUpdate(s);
    }

    @Override
    public void create(Student s) {
        studentRepository.create(s);
    }

    @Override
    public void update(Student s) {
        studentRepository.update(s);
    }

    @Override
    public Student findById(String id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public void deleteById(String id) {
        studentRepository.deleteById(id);
    }

    @PostConstruct
    public void init() {
        System.out.println("Init method called");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Detroy method called");
    }
}
