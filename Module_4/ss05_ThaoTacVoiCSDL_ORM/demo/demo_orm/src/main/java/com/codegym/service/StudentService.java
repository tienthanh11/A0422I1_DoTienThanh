package com.codegym.service;

import com.codegym.bean.Student;

import java.util.List;

public interface StudentService {
    void createOrUpdate(Student s);

    void create(Student s);

    void update(Student s);

    Student findById(String id);

    List<Student> findAll();

    List<Student> findByName(String name);

    void deleteById(String id);
}
