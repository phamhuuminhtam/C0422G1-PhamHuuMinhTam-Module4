package com.shopping.service.impl;

import com.shopping.model.Product;
import com.shopping.service.CartService;
import com.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private ProductService productService;
    @Override
    public void changeCart(Map<Product, Integer> cart, Long id, String expression) {
        Product product = productService.findById(id).orElse(null);
        if (cart.containsKey(product)) {
            if (expression.equals("+"))
                cart.put(product, cart.get(product) + 1);
            else {
                if(cart.get(product)>0)
                    cart.put(product, cart.get(product) - 1);
                else cart.remove(product);
            }
        } else cart.put(product, 1);
    }

    @Override
    public double total(Map<Product, Integer> cart) {
        double total = 0;
        Set<Product> products = cart.keySet();
        for (Product p : products) {
            total += p.getPrice() * cart.get(p);
        }
        return total;
    }
}
