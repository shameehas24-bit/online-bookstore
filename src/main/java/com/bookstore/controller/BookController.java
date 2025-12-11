package com.bookstore.controller;

import com.bookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    private final BookService service;

    public BookController(BookService service) { this.service = service; }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("books", service.listAll());
        return "index";
    }
}
