package com.codegym.controller;

import com.codegym.model.Medical;
import com.codegym.services.IMedicalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MedicalController {
    @Autowired
    private IMedicalServices iMedicalServices;

    @GetMapping(value = "")
    private ModelAndView getList() {
        List<Medical> medicals = iMedicalServices.findAll();
        return new ModelAndView("list", "list", iMedicalServices.findAll());
    }

    @GetMapping(value = "/add")
    private String showCreate(Model model) {
        model.addAttribute("medical", new Medical());
        model.addAttribute("listGender", new String[]{"Male", "Female", "Khác"});
        model.addAttribute("listQuocTich", new String[]{"Viet Nam", "USA", "China", "Korean"});
        return "declare";
    }

    @PostMapping(value = "/add")
    private String addNew(@ModelAttribute("medical") Medical medical, @RequestParam String ngayKhoiHanh,
                          @RequestParam String thangKhoiHanh, @RequestParam String namKhoiHanh,
                          @RequestParam String ngayKetThuc, @RequestParam String thangKetThuc,
                          @RequestParam String namKetThuc, RedirectAttributes redirectAttributes) {
        String thoiGianBatDau = ngayKhoiHanh + "/" + thangKhoiHanh + "/" + namKhoiHanh;
        String thoiGianKetThuc = ngayKetThuc + "/" + thangKetThuc + "/" + namKetThuc;
        medical.setNgayKhoiHanh(thoiGianBatDau);
        medical.setNgayKetThuc(thoiGianKetThuc);
        iMedicalServices.update(medical);
        return "redirect:/";
    }

//    private String getPage(Model model, @RequestParam(name = "id",defaultValue = "0") Integer id){
//        if (id==0){
//            model.addAttribute("email",new Email());
//        }else {
//            Email email = iEmailServices.find(id);
//            model.addAttribute("email",email);
//        }
//        model.addAttribute("listLanguages",new String []{"English","Vietnamese","Japanese","Chinese"});
//        return "update";
//    }
//    @GetMapping(value = "")
//    private ModelAndView getList(){
//        return  new ModelAndView("list","list",iEmailServices.findALL());
//    }
//    @PostMapping(value = "/save")
//    private String update(@ModelAttribute("email") Email email , RedirectAttributes redirectAttributes){
//        iEmailServices.update(email);
//        return "redirect:/";
//    }
}
