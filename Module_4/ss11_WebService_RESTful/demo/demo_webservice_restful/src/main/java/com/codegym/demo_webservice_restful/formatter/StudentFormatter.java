package com.codegym.demo_webservice_restful.formatter;

import com.codegym.demo_webservice_restful.entity.Student;
import com.codegym.demo_webservice_restful.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class StudentFormatter implements Formatter<Student> {

    private StudentService studentService;

    @Autowired
    public StudentFormatter(StudentService studentService) {
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
