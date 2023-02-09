package com.codegym.demo_1.controller;

import com.codegym.demo_1.model.Category;
import com.codegym.demo_1.model.Information;
import com.codegym.demo_1.service.ICategoryService;
import com.codegym.demo_1.service.IInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private IInformationService informationService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public String display(Model model, @PageableDefault(value = 5) Pageable pageable,
                          @RequestParam("title") Optional<String> title,
                          @RequestParam("categoryId") Optional<String> categoryId) {
        Page<Information> informationList;
        String condition = "";

        if (title.isPresent() || categoryId.isPresent()) {
            informationList = informationService.search(title.get(), categoryId.get(), pageable);
            model.addAttribute("informationList", informationList);
        }

        if (title.isPresent()) {
            condition += "&title=" + title.get();
            model.addAttribute("title", title.get());
        }
        if (categoryId.isPresent()) {
            condition += "&categoryId=" + categoryId.get();
            model.addAttribute("categoryId", categoryId.get());
        } else {
            informationList = informationService.findAll(pageable);
            model.addAttribute("informationList", informationList);
        }

        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("condition", condition);
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        List<Category> categoryList = categoryService.findAll();
        Information information = new Information();
        information.setCategoryId(new Category());
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("information", information);
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("information") Information information, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            information.setCategoryId(new Category());
            List<Category> categoryList = categoryService.findAll();

            model.addAttribute("categoryList", categoryList);
            model.addAttribute("information", information);
            return "create";
        }
        informationService.create(information);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {
        Information information = informationService.findById(id);
        model.addAttribute("information", information);
        return "list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idDelete") Integer id, RedirectAttributes redirectAttributes) {
        informationService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xoá thành công");
        return "redirect:/list";
    }
}
