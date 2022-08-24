package com.product_management_spring_data.service.impl;

import com.product_management_spring_data.model.Product;
import com.product_management_spring_data.repository.ProductRepository;
import com.product_management_spring_data.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;


    @Override
    public Page<Product> findAllByName(String name, Pageable pageable) {
        return productRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

}
