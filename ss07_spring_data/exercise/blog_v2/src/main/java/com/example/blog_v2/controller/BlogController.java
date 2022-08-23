package com.example.blog_v2.controller;

import com.example.blog_v2.model.Blog;
import com.example.blog_v2.service.BlogService;
import com.example.blog_v2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = {"", "/"})
    public String goList(Model model) {
        model.addAttribute("blogList", blogService.findAll());
        return "list";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "detail";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categoryList",categoryService.findAll());
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        blogService.remove(id);
        return "redirect:";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList",categoryService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:";
    }
}
