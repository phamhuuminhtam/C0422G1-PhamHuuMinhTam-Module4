package com.furama.controller;

import com.furama.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/contract")
@Controller
public class ContractController {
    @Autowired
    private ContractService contractService;

    @GetMapping("")
    public String goContract(Model model){
        model.addAttribute("contractList",contractService.showContract());
        return "/contract/contract";
    }
}
