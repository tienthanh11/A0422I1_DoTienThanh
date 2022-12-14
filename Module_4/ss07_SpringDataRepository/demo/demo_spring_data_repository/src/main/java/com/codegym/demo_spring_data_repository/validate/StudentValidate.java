package com.codegym.demo_spring_data_repository.validate;

import com.codegym.demo_spring_data_repository.entity.Student;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Student student = (Student) target;
        if (student.getPhoneNumber().length() != 10) {
            errors.rejectValue("phoneNumber", "phonenumber", new String[]{"10"}, "Số điện thoại không đúng định dạng");
        } else if (!student.getPhoneNumber().startsWith("0")) {
            errors.rejectValue("phoneNumber", "phonenumberstart", "Số điện thoại không đúng định dạng");
        }
    }
}
