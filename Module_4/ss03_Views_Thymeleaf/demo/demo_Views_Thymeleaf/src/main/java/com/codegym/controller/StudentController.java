package com.codegym.controller;

import com.codegym.bean.Student;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = {"/student/list", "/"}, method = RequestMethod.GET)
    public String displayList(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "list";
    }

    @GetMapping("/student/update")
    public String showUpdate(Model model, @RequestParam("id") String id) {
        model.addAttribute("student", studentService.findById(id));
        return "update";
    }

    @PostMapping("/student/update")
    public String doUpdate(@ModelAttribute("student") Student student) {
        studentService.createOrUpdate(student);
        return "redirect:/student/list";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/student/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "detail";
    }
}
