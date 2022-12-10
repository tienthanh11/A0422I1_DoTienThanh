package com.codegym.demo_jpa_spring_boot.service.impl;

import com.codegym.demo_jpa_spring_boot.model.Student;
import com.codegym.demo_jpa_spring_boot.repository.IStudentRepository;
import com.codegym.demo_jpa_spring_boot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        // Cách 1
//        Optional<Student> student = studentRepository.findById(id);
//        if (student.isPresent()) {
//            return student.get();
//        } else {
//            return null;
//        }

        //Cách 2
        return studentRepository.findById(id).orElse(null);

    }
}
