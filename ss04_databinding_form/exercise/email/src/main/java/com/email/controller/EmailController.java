package com.email.controller;

import com.email.model.EmailForm;
import com.email.model.Language;
import com.email.model.PageSize;
import com.email.service.LanguageService;
import com.email.service.PageSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmailController {

    @Autowired
    private LanguageService languageService;

    @Autowired
    private PageSizeService pageSizeService;

    @GetMapping("/")
    public String goHome(Model model) {
        List<Language> languageList = languageService.findAll();
        List<PageSize> pageSizeList = pageSizeService.findAll();
        model.addAttribute("emailForm", new EmailForm());
        model.addAttribute("languageList", languageList);
        model.addAttribute("pageSizeList", pageSizeList);
        return "home";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute EmailForm emailForm, Model model) {
        model.addAttribute("emailForm", emailForm);
        return "details";
    }
}
