package com.codegym.demo_ajax.restcontroller;

import com.codegym.demo_ajax.entity.ClassName;
import com.codegym.demo_ajax.entity.Student;
import com.codegym.demo_ajax.form.StudentForm;
import com.codegym.demo_ajax.service.ClassNameService;
import com.codegym.demo_ajax.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class RestStudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassNameService classNameService;

    @GetMapping("/list")
    public ResponseEntity<List<Student>> getListStudent() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") String id ) {
        Student student = studentService.findById(id);
        if (student == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/create")
    public String createStudent(@RequestBody StudentForm studentForm) {
        String id = studentForm.getId();
        String name = studentForm.getName();
        ClassName className = classNameService.findById(studentForm.getClassNameId());
        boolean sex = studentForm.getSex().equals("1") ? true: false;
        String email = studentForm.getEmail();
        String phoneNumber = studentForm.getPhoneNumber();
        Student student = new Student(id, name, className, email, sex, phoneNumber, null);
        studentService.create(student);
        return "success";
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<Student>> list(Model model, @RequestParam(value = "name", defaultValue = "") String name) {
        List<Student> students = "".equals(name) ? studentService.findAll(): studentService.findByName(name);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
