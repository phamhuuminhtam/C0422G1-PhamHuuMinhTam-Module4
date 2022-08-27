package com.furama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/contract")
@Controller
public class ContractController {
    @GetMapping("")
    public String goContract(){
        return "/contract/contract";
    }
}
