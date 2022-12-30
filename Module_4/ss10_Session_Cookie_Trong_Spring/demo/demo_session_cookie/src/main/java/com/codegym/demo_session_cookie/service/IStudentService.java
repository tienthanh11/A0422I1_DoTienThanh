package com.codegym.demo_session_cookie.service;

import com.codegym.demo_session_cookie.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void create(Student student);

    void update(Student student);

    void delete(String id);

    Student findById(String id);

    Page<Student> findAllWithPaging(Pageable pageable);

    Slice<Student> findAllWithSlice(Pageable pageable);
}
