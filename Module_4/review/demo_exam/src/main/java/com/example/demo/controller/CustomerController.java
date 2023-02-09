package com.example.demo.controller;

import com.example.demo.exception.CustomerException;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerType;
import com.example.demo.service.ICustomerService;
import com.example.demo.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping("/list")
    public String listCustomer(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("customerList", customerService.findAll(PageRequest.of(page, 5)));
        return "list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        List<CustomerType> customers = customerTypeService.findAll();
        model.addAttribute("customerTypeList", customers);
        model.addAttribute("customerList", new Customer());
        return "create";
    }

//    @PostMapping("/create")
//    public String create(@Valid @ModelAttribute("customer") Customer customer, Model model) {
//        customerService.create(customer);
//        model.addAttribute("mess", "Add new success.");
//        return "redirect:/list";
//    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("customerList") Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("mess", "Add new failse.");
//            model.addAttribute("customerList", customer);
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "/create";
        }
        customerService.create(customer);
        model.addAttribute("mess", "Add new success.");
        return "redirect:/list";
    }

    @GetMapping("/edit/{id_customer}")
    public String editForm(@PathVariable("id_customer") String id, Model model) {
        Optional<Customer> customer =customerService.findById(id);
        List<CustomerType> customerType = customerTypeService.findAll();
        model.addAttribute("customerList", customer);
        model.addAttribute("customerTypeList", customerType);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit (@Valid @ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.create(customer);
        redirectAttributes.addFlashAttribute("mess", "Edit success");
        return "redirect:/list";
    }

//    @PostMapping("/edit")
//    public String edit (@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addAttribute("mess", "Edit customer failse.");
//            return "create";
//        }
//
//        customerService.create(customer);
//        redirectAttributes.addFlashAttribute("mess", "Edit success");
//        return "redirect:/list";
//    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") String id, Model model) {
        Optional<Customer> customer = customerService.findById(id);
        model.addAttribute("customerList", customer.orElse(null));
        return "detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id, Model model) {
        customerService.delete(id);
        model.addAttribute("mess", "Delete success.");
        return "redirect:/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("nameSearch") String name, Pageable pageable, Model model) {
        Page customer = customerService.search(name, pageable);
        model.addAttribute("customerList", customer);
        return "/list";
    }

    @ExceptionHandler(CustomerException.class)
    public String errorHandler(CustomerException e, Model model) {
        model.addAttribute("message", e.getMessage());
        System.out.println("=============Customer Controller=============");
        return "exception";
    }
}
