package code.controller;

import code.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import code.service.iProductService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    iProductService productService;

    @ModelAttribute("product")
    public Product initProduct() {
        return new Product();
    }

    @GetMapping("list")
    public String show(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "/list";
    }

    @GetMapping("/create")
    public String add(Model model) {
        return "create";
    }

    @PostMapping("/create")
    public String add(@ModelAttribute("product") Product product, Model model) {
        productService.save(product);
        //model.addAttribute("mess", "Add new success");
        return "redirect:/product/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("productList", product);
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("product") Product product) {
        productService.update(product.getId(), product);
        return "redirect:/product/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam("nameSearch") String nameSearch, Model model) {
        List<Product> productList = productService.search(nameSearch);
        if (productList.isEmpty()) {
            model.addAttribute("mess", "Not found product.");
        } else {
            model.addAttribute("productList", productList);
        }
        return "/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@RequestParam("deleteId") int deleteId, Model model) {
        System.out.println(deleteId);
        model.addAttribute("mess", "Remove product suscessfully.");
        productService.remove(deleteId);
        return "/list";
    }

//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable("deleteId") int deleteId, RedirectAttributes redirectAttributes) {
//        redirectAttributes.addFlashAttribute("mess", "Remove product suscessfully.");
//        productService.remove(deleteId);
//        return "/list";
//    }
}
