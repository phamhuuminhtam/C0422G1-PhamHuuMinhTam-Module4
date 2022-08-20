package com.product_management.repository;

import com.product_management.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll(String name);

    void add(Product product);

    void update(Product product);

    Product findById(int id);

    void delete(int id);
}
