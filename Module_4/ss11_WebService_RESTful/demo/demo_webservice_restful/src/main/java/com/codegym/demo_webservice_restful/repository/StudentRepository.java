package com.codegym.demo_webservice_restful.repository;

import codegym.vn.springboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
}
