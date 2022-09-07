package com.example.blog_v2.controller;

import com.example.blog_v2.config.WebSecurityConfig;
import com.example.blog_v2.model.Blog;
import com.example.blog_v2.service.BlogService;
import com.example.blog_v2.service.CategoryService;
import com.example.blog_v2.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = {"", "/", "/search"})
    public String goList(Model model, @PageableDefault(value = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                         @RequestParam Optional<String> key, @ModelAttribute("blog") Blog blog, Principal principal) {
        String keyVal = key.orElse("");
        if (blog.getCategory()!=null) {
            model.addAttribute("blogList", blogService.findAllByTitleContainingAndCategory_Id(keyVal, blog.getCategory().getId(), pageable));

        } else {
            model.addAttribute("blogList", blogService.findAllByTitleContaining(keyVal, pageable));
        }
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("keyWord", keyVal);
        model.addAttribute("blog", blog);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String check = WebUtils.toString(loginedUser);
        model.addAttribute("check",check);

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
        model.addAttribute("categoryList", categoryService.findAll());
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
        model.addAttribute("categoryList", categoryService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:";
    }


}
