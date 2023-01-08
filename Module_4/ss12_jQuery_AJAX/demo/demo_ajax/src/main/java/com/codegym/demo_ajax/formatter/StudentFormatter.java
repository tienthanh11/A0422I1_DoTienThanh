package com.codegym.demo_ajax.formatter;

import com.codegym.demo_ajax.entity.Student;
import com.codegym.demo_ajax.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class StudentFormatter implements Formatter<Student> {

    private StudentService studentService;
    @Autowired
    public StudentFormatter(StudentService service) {
        this.studentService = service;
    }
    @Override
    public Student parse(String text, Locale locale) throws ParseException {
        return studentService.findById(text);
    }

    @Override
    public String print(Student object, Locale locale) {
        return object.toString();
    }
}
