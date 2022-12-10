package com.codegym.demo_jpa_spring_boot.controller;

import com.codegym.demo_jpa_spring_boot.model.Student;
import com.codegym.demo_jpa_spring_boot.service.IStudentService;
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
    private IStudentService studentService;

    //    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("listStudent", studentService.getAll());
        return "list";
    }

    @GetMapping(value = "detail/{id}")
    public String showDetail(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "detail";
    }

    @GetMapping(value = "detail")
    public String showDetailByRequestParam(@RequestParam(defaultValue = "2") int id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "detail";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("listGender", new String[]{"1", "0"});
        return "/create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("student") Student student,
                                Model model,
                                RedirectAttributes redirectAttributes) {
        studentService.save(student);
//        List<Student> list = iStudentService.getAll();
//        model.addAttribute("listStudent", list);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/list";
    }
}
