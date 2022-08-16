package com.sandwich_condiments.controller;

import com.sandwich_condiments.service.CondimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SandWichCondimentsController {
    @Autowired
    private CondimentService condimentService;

    @GetMapping("/home")
    public String goHome(Model model) {
        model.addAttribute("list", condimentService.findAll());
        return "menu";
    }

    @PostMapping("/condiment")
    public String chooseCondiment(@RequestParam("condiment") String[] condiment, Model model) {
        model.addAttribute("choose", condiment);
        model.addAttribute("list", condimentService.findAll());
        return "menu";
    }
}
