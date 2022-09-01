package com.example.blog_v2.controller;

import com.example.blog_v2.model.Blog;
import com.example.blog_v2.model.Category;
import com.example.blog_v2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/category")
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String categoryList(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        return "/category/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new Category());
        return "/category/create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute Category category) {
        categoryService.create(category);
        return "redirect:";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam Integer id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
          return "/category/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Category category) {
        categoryService.create(category);
        return "redirect:";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        categoryService.delete(id);
        return "redirect:";
    }
}
