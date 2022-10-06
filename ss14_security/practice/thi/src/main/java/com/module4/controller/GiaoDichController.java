package com.module4.controller;

import com.module4.service.GiaoDichService;
import com.module4.service.TypeServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GiaoDichController {
    @Autowired
    private GiaoDichService giaoDichService;
    @Autowired
    private TypeServiceService typeServiceService;
    @GetMapping("")
    public String getList(Model model){

        model.addAttribute("gdList",giaoDichService.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String showAdd(Model model){
        model.addAttribute("typeServiceList",typeServiceService.findAll());

        return "add";
    }
}
