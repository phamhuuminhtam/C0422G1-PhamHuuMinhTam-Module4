package com.example.blog_v2.controller;

import com.example.blog_v2.model.Blog;
import com.example.blog_v2.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/blogrests")
public class BlogRestController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public ResponseEntity<Page<Blog>> goBlogListRest(@RequestParam String title,@PageableDefault Pageable pageable){
        Page<Blog> blogPage = blogService.findAllByTitleContaining(title,pageable);
        if(!blogPage.hasContent()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping("/blog-in-category")
    public ResponseEntity<Page<Blog>> showBlogInCategory(@RequestParam Integer id, @PageableDefault(size = 5) Pageable pageable){
        Page<Blog> blogPage = blogService.findAllByCategory_Id(id, pageable);
        if(!blogPage.hasContent()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(blogPage,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> showBlogDetail(@PathVariable Integer id){
        Blog blog = blogService.findById(id);
        if(blog ==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(blog,HttpStatus.OK);
    }

}
