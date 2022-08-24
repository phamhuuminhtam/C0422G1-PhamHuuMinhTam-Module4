package com.example.blog_v2.service;

import com.example.blog_v2.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    void create(Category category);

    void delete(Integer id);

    Category findById(Integer id);
}
