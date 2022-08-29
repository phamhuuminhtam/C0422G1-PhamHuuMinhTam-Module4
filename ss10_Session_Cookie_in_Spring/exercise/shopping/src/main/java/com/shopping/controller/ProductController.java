package com.shopping.controller;

import com.shopping.model.Product;
import com.shopping.service.CartService;
import com.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@SessionAttributes("cart")
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @ModelAttribute("cart")
    public Map<Product, Integer> cart() {
        return new HashMap<>();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/detail")
    public String goDetail(@RequestParam Long id, Model model) {
        Product product = productService.findById(id).orElse(null);
        if (product == null) {
            return "/error.404";
        }
        model.addAttribute("product", product);
        return "detail";
    }

    @GetMapping(value = {"/add"})
    public String addToCart(@RequestParam(defaultValue = "0") Long id, String expression, Model model, @SessionAttribute Map<Product, Integer> cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        cartService.changeCart(cart,id,expression);
                model.addAttribute("total", cartService.total(cart));
                model.addAttribute("cart", cart);
        return "cart";
    }
    @GetMapping("/remove")
    public String removeToCart(@SessionAttribute Map<Product, Integer> cart,@RequestParam Long id, Model model ){
        Product product = productService.findById(id).orElse(null);
        cart.remove(product);
        model.addAttribute("total", cartService.total(cart));
        model.addAttribute("cart", cart);
        return "cart";
    }
}
