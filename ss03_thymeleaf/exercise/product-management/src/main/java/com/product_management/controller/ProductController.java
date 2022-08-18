package com.product_management.controller;

import com.product_management.model.Product;
import com.product_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String goList(Model model){
    model.addAttribute("productList",productService.findAll());
    return "list";
    }

    @GetMapping("/create")
    public String goCreate(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }

    @PostMapping("/create")
    public String createNewProduct(@ModelAttribute Product product){
        productService.add(product);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String goUpdate(@RequestParam int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "update";
    }

    @PostMapping("/update")
    public  String updateProduct(@ModelAttribute Product product){
        productService.update(product);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id){
        productService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam String name, Model model){
        List<Product> productList = productService.searchByName(name);
        model.addAttribute("productList",productList);
        return "list";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam int id, Model model){
      Product product =  productService.showDetail(id);
      model.addAttribute("product",product);
      return "detail";
    }
}
