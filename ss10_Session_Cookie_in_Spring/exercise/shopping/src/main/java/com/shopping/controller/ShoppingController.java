package com.shopping.controller;

import com.shopping.model.Product;
import com.shopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Map;

@Controller
public class ShoppingController {

    @Autowired
    private CartService cartService;
    @GetMapping("/shopping-cart")
    public  String goCart(Model model, @SessionAttribute Map<Product, Integer> cart){
        model.addAttribute("cart",cart);
        model.addAttribute("total", cartService.total(cart));
        return "cart";
    }
}
