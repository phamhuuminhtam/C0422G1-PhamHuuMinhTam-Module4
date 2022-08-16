package com.calculator.controller;

import com.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/home")
    public String goHome(){
        return "home";
    }
    @PostMapping("/solve")
    public String calculate(@RequestParam String numb1,@RequestParam String numb2,@RequestParam String action, Model model){
        String result =calculatorService.solve(numb1,numb2,action);
        model.addAttribute("result",result);
        model.addAttribute("numb1",numb1);
        model.addAttribute("numb2",numb2);
        model.addAttribute("action",action);
        return "home";
    }
}
