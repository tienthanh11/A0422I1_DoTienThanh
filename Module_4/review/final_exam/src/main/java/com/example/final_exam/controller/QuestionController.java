package com.example.final_exam.controller;

import com.example.final_exam.model.QuestionContent;
import com.example.final_exam.model.QuestionType;
import com.example.final_exam.repository.IQuestionContentRepo;
import com.example.final_exam.service.IQuestionContentService;
import com.example.final_exam.service.IQuestiontypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class QuestionController {
    @Autowired
    IQuestionContentService questionContentService;
    @Autowired
    IQuestiontypeService questiontypeService;

    @GetMapping("/list")
    public String listQuestion(Model model, @RequestParam(value = "page", defaultValue = "1") int page){
        model.addAttribute("questionTypeList", questiontypeService.findAll());
        model.addAttribute("questionContentList", questionContentService.findAll(PageRequest.of(page, 1)));
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        List<QuestionType> questionTypes = questiontypeService.findAll();
        model.addAttribute("questionTypeList", questionTypes);
        model.addAttribute("questionContentList", new QuestionContent());
        return "create";
    }
//    @PostMapping("/create")
//    public String create(@Valid @ModelAttribute("questionList") QuestionContent questionContent, Model model) {
//        questionContentService.create(questionContent);
//        model.addAttribute("mess", "Add new question success.");
//        return "redirect:/list";
//    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("questionList") QuestionContent questionContent, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("mess", "Add new failse.");
            model.addAttribute("questionTypeList", questiontypeService.findAll());
            return "/create";
        }
        questionContentService.create(questionContent);
        model.addAttribute("mess", "Add new question success.");
        return "redirect:/list";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") Integer id, Model model) {
        Optional<QuestionContent> questionContent = questionContentService.findById(id);
        model.addAttribute("questionContentList", questionContent.orElse(null));
        return "detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id, Model model) {
        questionContentService.delete(id);
        model.addAttribute("mess", "Delete sussess.");
        return "redirect:/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("titleSearch") String title, Pageable pageable, Model model) {
        Page question = questionContentService.search(title, pageable);
        model.addAttribute("questionContentList", question);
        return "/list";
    }

    @ExceptionHandler(Error.class)
    public String error(Error e, Model model) {
        model.addAttribute("mess", e.getMessage());
        return "error";
    }
}
