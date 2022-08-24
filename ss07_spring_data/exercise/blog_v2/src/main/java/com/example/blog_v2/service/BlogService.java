package com.example.blog_v2.service;


import com.example.blog_v2.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BlogService {

    Iterable<Blog> findAll();

    Blog findById(Integer id);

    void save(Blog blog);

    void update(Blog blog);

    void remove(Integer id);

    Page<Blog> findAllPage(Pageable pageable);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    Page<Blog> findAllByTitleContainingAndCategory_Id(String title, Integer id, Pageable pageable);

}
