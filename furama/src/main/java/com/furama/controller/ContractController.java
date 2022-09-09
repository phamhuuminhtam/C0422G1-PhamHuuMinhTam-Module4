package com.furama.controller;

import com.furama.model.contract.Contract;
import com.furama.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public String goContract(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("contractList", contractService.getContractPage(pageable));
        model.addAttribute("size",pageable.getPageSize());
        return "/contract/contract";
    }
}
