package com.codegym.repository.impl;

import com.codegym.model.Student;
import com.codegym.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "thanhDT1", 9, 1));
        students.add(new Student(2, "thanhDT2", 3, 0));
        students.add(new Student(3, "thanhDT3", 6, 1));
        students.add(new Student(4, "thanhDT4", 8, null));
        students.add(new Student(5, "thanhDT5", 5, 1));
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public void save(Student student) {
        students.add(student);
    }

    @Override
    public Student findById(Integer codeStudent) {
        for(Student student : students) {
            if(student.getCodeStudent() == codeStudent) {
                return student;
            }
        }
        return null;
    }
}
