package com.product_management.service;

import com.product_management.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll(String name);
    void add(Product product);
    void update(Product product);
    Product findById(int id);
    void delete(int id);

}
