package com.codegym.demo_spring_data_repository.repository;

import com.codegym.demo_spring_data_repository.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
