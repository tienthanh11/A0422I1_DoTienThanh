package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertCurrencyController {
    private double vnd;
    @GetMapping(value = "")
    public String index() {
        return "index";
    }

    @PostMapping(value = "")
    public String convert(@RequestParam(name = "usd") double usd, Model model) {
        vnd = usd * 22000;
        model.addAttribute("vnd", vnd);
        return "index";
    }
}
