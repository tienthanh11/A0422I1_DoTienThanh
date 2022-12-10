package com.codegym.demo_jpa_spring_boot.repository;

import com.codegym.demo_jpa_spring_boot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    //Các vấn đề thay đổi dữ liệu thì dùng Annotation bên dưới
    //@Transactional
    //@Modifying

    @Query(value = "select s from student as s where s.nameStudent like :name", nativeQuery = false)
    List<Student> findAllByNameStudentContaining(@Param("name") String nameStudent);
}
