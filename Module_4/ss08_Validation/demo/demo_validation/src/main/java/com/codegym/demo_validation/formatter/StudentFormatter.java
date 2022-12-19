package com.codegym.demo_validation.formatter;

import com.codegym.demo_validation.model.Student;
import com.codegym.demo_validation.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class StudentFormatter implements Formatter<Student> {

    private IStudentService studentService;

    @Autowired
    public StudentFormatter(IStudentService studentService) {
        this.studentService = studentService;
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
