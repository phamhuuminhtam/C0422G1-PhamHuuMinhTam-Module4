package com.example.blog_v2.service;


import com.example.blog_v2.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BlogService {

    public Iterable<Blog> findAll();


    public Blog findById(Integer id);


    public void save(Blog blog);


    public void update(Blog blog);


    public void remove(Integer id);

    Page<Blog> findAllPage(Pageable pageable);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
    Page<Blog> findAllByTitleContainingAndCategory_Id(String title,Integer id, Pageable pageable);

}
