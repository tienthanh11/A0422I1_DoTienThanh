package com.codegym.casestudy_spring_module_4.controller;

import com.codegym.casestudy_spring_module_4.model.RentType;
import com.codegym.casestudy_spring_module_4.model.Service;
import com.codegym.casestudy_spring_module_4.model.ServiceType;
import com.codegym.casestudy_spring_module_4.service.IRentTypeService;
import com.codegym.casestudy_spring_module_4.service.IServiceService;
import com.codegym.casestudy_spring_module_4.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("/list")
    public String display(Model model, @PageableDefault(value = 4) Pageable pageable) {
        Page<Service> serviceList = serviceService.findAllService(pageable);
        List<ServiceType> serviceTypeList = serviceTypeService.findAllTypeService();
        List<RentType> rentTypeList = rentTypeService.findAllRentType();
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("serviceTypeList", serviceTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        return "service/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        List<ServiceType> serviceTypeList = serviceTypeService.findAllTypeService();
        List<RentType> rentTypeList = rentTypeService.findAllRentType();
        Service service = new Service();
        service.setServiceTypeId(new ServiceType());
        service.setRentTypeId(new RentType());
        model.addAttribute("service", service);
        model.addAttribute("serviceTypeList", serviceTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        return "service/create";
    }
}
