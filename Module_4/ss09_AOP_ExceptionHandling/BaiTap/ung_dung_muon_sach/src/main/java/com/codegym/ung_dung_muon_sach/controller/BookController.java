package com.codegym.ung_dung_muon_sach.controller;

import com.codegym.ung_dung_muon_sach.error.QuantityZero;
import com.codegym.ung_dung_muon_sach.error.WrongCodeRent;
import com.codegym.ung_dung_muon_sach.model.Book;
import com.codegym.ung_dung_muon_sach.model.Rent;
import com.codegym.ung_dung_muon_sach.service.IBookService;
import com.codegym.ung_dung_muon_sach.service.IRentService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    IBookService bookService;

    @Autowired
    IRentService rentService;

    @GetMapping("/list")
    public String showLibrary(Model model) {
        model.addAttribute("listBook", bookService.findAll());
        return "library";
    }

    @SneakyThrows
    @GetMapping("/rent/{id}")
    public String rentBook(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        Optional<Book> book = bookService.findById(id);
        assert book.isPresent();
        if (book.get().getQuantity() > 0) {
            book.get().setQuantity(book.get().getQuantity() - 1);
            bookService.save(book.get());
            redirectAttributes.addFlashAttribute("message", "Rent successfully");
            return "redirect:/books/list";
        }

        if (book.get().getQuantity() <= 0) {
            throw new QuantityZero("This book was rent empty");
        }
        return "redirect:/books/list";
    }

    @GetMapping("/listRent")
    public String showListRent(Model model) {
        model.addAttribute("listRent", rentService.findAll());
        return "library";
    }

    @SneakyThrows
    @GetMapping("/pay")
    public String returnBook(@RequestParam("idReturn") Integer idReturn, RedirectAttributes redirectAttributes) {
        Optional<Rent> rent = rentService.findById(idReturn);
        if (rent.isPresent()) {
            rent.get().setStatus("off");
            rentService.save(rent.get());
            Book book = bookService.findById(rent.get().getBook().getId()).get();
            book.setQuantity(book.getQuantity() + 1);
            bookService.save(book);
            redirectAttributes.addFlashAttribute("message", "Return successfully");
        }
        if (!rent.isPresent()) {
            throw new WrongCodeRent("Wrong code input again");
        }
        return "redirect:/books/list";
    }
}
