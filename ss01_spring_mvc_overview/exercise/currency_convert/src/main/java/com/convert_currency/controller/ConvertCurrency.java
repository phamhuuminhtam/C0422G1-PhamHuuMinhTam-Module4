package com.convert_currency.controller;

import com.convert_currency.service.ConvertCurrencySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertCurrency {
    @Autowired
    private ConvertCurrencySerivce convertCurrencySerivce;

    @GetMapping("/goConvertPage")
    public  String goConvertPage(){
        return "input";
    }


    @PostMapping("/goConvert")
    public  String goConvert(@RequestParam double usd, double rate, Model model){
        double result =convertCurrencySerivce.convertCurrency(usd,rate);
        model.addAttribute("result",result);
        model.addAttribute("usd",usd);
        model.addAttribute("rate",rate);
        return "input";
    }




}
