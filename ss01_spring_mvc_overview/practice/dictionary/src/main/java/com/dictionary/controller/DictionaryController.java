package com.dictionary.controller;

import com.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/page")
    public  String goPage(){
        return "translate";
    }


    @PostMapping("/translate")
public String translate(@RequestParam String word, Model model){
        String result = dictionaryService.translate(word);
        model.addAttribute("result",result);
        model.addAttribute("word",word);
        return "translate";
    }
}
