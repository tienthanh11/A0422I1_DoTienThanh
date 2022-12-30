package com.codegym.demo_session_cookie.repository;

import com.codegym.demo_session_cookie.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, String> {
}
