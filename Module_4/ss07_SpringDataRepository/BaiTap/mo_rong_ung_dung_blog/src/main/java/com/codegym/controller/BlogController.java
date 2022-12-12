package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("/list")
    public String display(Model model, @RequestParam("page")  Optional<Integer> page,
                          @RequestParam("size") Optional<Integer> size,
                          @RequestParam("name") Optional<String> name) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(4);

        List<Category> categoryList = categoryService.findAll();
        Page<Blog> blogList;
        if(name.isPresent()) {
            blogList = blogService.search(name.get(), PageRequest.of(currentPage - 1, pageSize));
            model.addAttribute("name", name.get());
        } else {
            blogList = blogService.findAll(PageRequest.of(currentPage - 1, pageSize));
        }
        int totalPages = blogList.getTotalPages();
        if(totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1 , totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        model.addAttribute("blogList", blogList);
        model.addAttribute("categoryList", categoryList);
        return "blog/list";
    }


    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/view";
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        List<Category> categoryList = categoryService.findAll();

        Blog blog = new Blog();
        blog.setCategory(new Category());

        model.addAttribute("blog", blog);
        model.addAttribute("categoryList", categoryList);
        return "blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.create(blog);
        redirectAttributes.addFlashAttribute("mess", "Add New Blog Successfully");
        return "redirect:/blog/list";
    }

    @GetMapping("/edit/{id}")
    public String viewEdit(@PathVariable("id") Integer id, Model model) {
        Blog blog = blogService.findById(id);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("blog", blog);
        model.addAttribute("categoryList", categoryList);
        return "blog/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("mess", "Edit Blog Successfully");
        return "redirect:/blog/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Delete Blog Successfully");
        return "redirect:/blog/list";
    }
}
