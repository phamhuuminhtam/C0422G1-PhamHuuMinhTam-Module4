package com.example.blog_v2.service.impl;

import com.example.blog_v2.model.Category;
import com.example.blog_v2.repository.CategoryRepository;
import com.example.blog_v2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


    public void create(Category category){
        categoryRepository.save(category);
    }

    public  void delete(Integer id){
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
