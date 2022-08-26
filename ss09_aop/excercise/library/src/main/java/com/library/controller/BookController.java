package com.library.controller;

import com.library.model.Book;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String goList(Model model) {
        model.addAttribute("list", bookService.findAll());
        return "list";
    }

    @GetMapping("/detail")

    public String view(Model model, @RequestParam String name) {
        try {
            model.addAttribute("book", bookService.findAllByName(name));
            return "detail";
        } catch (Exception e) {
            return "err";
        }
    }

    @GetMapping("/borrow")
    public String borrow(Model model, @RequestParam String name, RedirectAttributes redirectAttributes) throws Exception {

        Book bookBorrow = bookService.findByName(name);
        if (bookBorrow == null) {
            throw new Exception();
        }
        Integer id = bookBorrow.getId();
        bookService.borrow(id);
        model.addAttribute("list", bookService.findAll());
        model.addAttribute("idBook", id);
        return "list";

    }

    @GetMapping("/returnBook")
    public String returnBook(@RequestParam Integer idBorrow, Model model) throws Exception {
        if (bookService.returnBookCheckId(idBorrow) == null) {
            throw new Exception();
        }
        bookService.returnBook(idBorrow);
        model.addAttribute("list", bookService.findAll());
        return "list";
    }

    @ExceptionHandler(value = Exception.class)
    public String goErrPage() {
        return "err";
    }
}
