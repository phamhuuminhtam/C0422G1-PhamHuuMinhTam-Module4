package com.product_management_spring_data.controller;


import com.product_management_spring_data.model.Product;
import com.product_management_spring_data.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String createNewProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.add(product);
        redirectAttributes.addFlashAttribute("msg", "Add complete");
        return "redirect:/home";
    }

    @GetMapping("/edit")
    public String goUpdate(@RequestParam int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.update(product);
        redirectAttributes.addFlashAttribute("msg", "update complete");
        return "redirect:/home";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id, RedirectAttributes redirectAttributes) {
        productService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "delete complete");
        return "redirect:/home";
    }

    @GetMapping(value = {"/search", "/home", ""})
    public String searchByName(@RequestParam(defaultValue = "") String name, Model model, @PageableDefault(size = 2)Pageable pageable) {
        model.addAttribute("productList", productService.findAllByName(name,pageable));
        model.addAttribute("size",pageable.getPageSize());
        return "list";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "detail";
    }
}
