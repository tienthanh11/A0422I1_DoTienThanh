package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {

    @Autowired
    @Qualifier("studentService")
    private IStudentService iStudentService;

//    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @GetMapping(value = "/list")
    public String showList(Model model) {
        model.addAttribute("listStudent", iStudentService.getAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        model.addAttribute("student", new Student(0, "", 0, 0));
        String[] genderList = {"0", "1", " 2"};
        model.addAttribute("genderList", genderList);
        return "create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("student") Student temp, RedirectAttributes redirectAttributes) {
        iStudentService.save(temp);
//        List<Student> list = iStudentService.getAll();
//        model.addAttribute("listStudent", list);
        redirectAttributes.addFlashAttribute("msg", "create new successfully");
        return "redirect:/list";
    }

    @GetMapping(value = "/detail/{id}")
    public String showDetailByPathVariable(@PathVariable(value = "id") Integer codeStudent, Model model) {
        System.out.println(codeStudent);
        Student student = iStudentService.findById(codeStudent);
        model.addAttribute("student", student);
        return "detail";
    }

    @GetMapping(value = "/detail")
    public String showDetailByRequestParam(@RequestParam("id") Integer codeStudent, Model model) {
        System.out.println(codeStudent);
        Student student = iStudentService.findById(codeStudent);
        model.addAttribute("student", student);
        return "detail";
    }
}