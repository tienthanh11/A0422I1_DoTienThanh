package com.codegym.exam.controller;

import com.codegym.exam.model.Customer;
import com.codegym.exam.model.Service;
import com.codegym.exam.repository.ICustomerRepository;
import com.codegym.exam.service.ICustomerService;
import com.codegym.exam.service.IServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private IServerService serverService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/list")
    public String display(Model model, @PageableDefault(value = 5) Pageable pageable,
                          @RequestParam("serviceType") Optional<String> serviceType,
                          @RequestParam("customerId") Optional<String> customerId) {
        Page<Service> serviceList;
        String condition = "";

        if(serviceType.isPresent() || customerId.isPresent()) {
            serviceList = serverService.search(serviceType.get(), customerId.get(), pageable);
            model.addAttribute("serviceList", serviceList);
        }

        if (serviceType.isPresent()) {
            condition += "&serviceType=" + serviceType.get();
            model.addAttribute("serviceType", serviceType.get());
        }
        if (customerId.isPresent()) {
            condition += "&categoryId=" + customerId.get();
            model.addAttribute("categoryId", customerId.get());
        } else {
            serviceList = serverService.findAll(pageable);
            model.addAttribute("serviceList", serviceList);
        }

        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList", customerList);
        model.addAttribute("condition", condition);
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        List<Customer> customerList = customerService.findAll();
        Service service = new Service();
        service.setCustomer(new Customer());
        model.addAttribute("customerList", customerList);
        model.addAttribute("service", service);
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("service") Service service, BindingResult bindingResult, Model model,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            service.setCustomer(new Customer());
            List<Customer> customerList = customerService.findAll();

            model.addAttribute("customerList", customerList);
            model.addAttribute("service", service);
            return "create";
        }
        serverService.save(service);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {
        Service service = serverService.findById(id);
        model.addAttribute("service", service);
        return "list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idDelete") Integer id, RedirectAttributes redirectAttributes) {
        serverService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xoá thành công");
        return "redirect:/list";
    }
}
