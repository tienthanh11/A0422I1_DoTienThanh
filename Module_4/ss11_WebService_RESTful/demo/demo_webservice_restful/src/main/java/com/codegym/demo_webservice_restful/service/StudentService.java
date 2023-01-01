package com.codegym.demo_webservice_restful.service;

import com.codegym.demo_webservice_restful.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface StudentService {
    void create(Student student);

    void update(Student student);

    void delete(String id);

    List<Student> findAll();

    Student findById(String id);

    Page<Student> findAllWithPaging(Pageable pageable);

    Slice<Student> findAllWithSlice(Pageable pageable);
}
