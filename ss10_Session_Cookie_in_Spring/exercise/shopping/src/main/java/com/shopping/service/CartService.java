package com.shopping.service;

import com.shopping.model.Product;

import java.util.Map;

public interface CartService {
    void changeCart(Map<Product,Integer> cart, Long id, String expression);

    double total(Map<Product,Integer> cart);
}
