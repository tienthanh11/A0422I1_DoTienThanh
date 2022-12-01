package com.codegym.repository;

import com.codegym.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> getAll();

    void save(Student student);

    Student findById(Integer codeStudent);
}
