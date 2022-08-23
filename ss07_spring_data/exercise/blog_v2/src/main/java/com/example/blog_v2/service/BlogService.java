package com.example.blog_v2.service;


import com.example.blog_v2.model.Blog;



public interface BlogService  {

    public Iterable<Blog> findAll();


    public Blog findById(Integer id);


    public void save(Blog blog);


    public void update(Blog blog);


    public void remove(Integer id);

}
