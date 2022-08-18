package com.product_management.service.impl;

import com.product_management.model.Product;
import com.product_management.repository.ProductRepository;
import com.product_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void add(Product product) {
        int id = (int) Math.floor(Math.random()*1000);
        product.setId(id);
        productRepository.add(product);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.searchByName(name);
    }

    @Override
    public Product showDetail(int id) {
        return productRepository.showDetail(id);
    }
}
