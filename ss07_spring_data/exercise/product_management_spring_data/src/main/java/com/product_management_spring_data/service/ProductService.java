package com.product_management_spring_data.service;

import com.product_management_spring_data.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Page<Product> findAllByName(String name, Pageable pageable);
    void add(Product product);

    void update(Product product);

    Product findById(int id);

    void delete(int id);

}
