package com.blog.controller;

import com.blog.model.Blog;
import com.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping(value={"","/goList"})
    public String goList(Model model){
        model.addAttribute("blogList",blogService.findAll());
        return "list";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam Integer id,Model model){
        model.addAttribute("blog",blogService.findById(id).get());
        return "detail";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam Integer id, Model model){
        model.addAttribute("blog",blogService.findById(id).get());
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "update complete");
        return "redirect:/goList";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Integer id,RedirectAttributes redirectAttributes){
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("msg", "update complete");
        return "redirect:/goList";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog blog,RedirectAttributes redirectAttributes){
       blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "update complete");
        return "redirect:/goList";
    }
}
