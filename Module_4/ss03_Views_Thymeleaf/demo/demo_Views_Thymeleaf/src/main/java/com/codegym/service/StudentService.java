package com.codegym.service;

import com.codegym.bean.Student;

import java.util.List;

public interface StudentService {
    void createOrUpdate(Student s);

    Student findById(String id);

    List<Student> findAll();

    void deleteById(String id);
}
