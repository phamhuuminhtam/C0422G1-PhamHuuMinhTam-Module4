package com.furama.controller;

import com.furama.model.contract.Contract;
import com.furama.service.contract.ContractService;
import com.furama.service.customer.CustomerService;
import com.furama.service.facility.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/contract")
@Controller
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private CustomerService customerService;
    @Autowired
    private FacilityService facilityService;

    @GetMapping("")
    public String goContract(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("contractList", contractService.getContractPage(pageable));
        model.addAttribute("size",pageable.getPageSize());
        return "/contract/contract";
    }

    @PostMapping("/add")
    public String addNewContact(){
        return "/contract/contract";
    }

    @GetMapping("/add")
    public String showAddContract(Model model){
        model.addAttribute("customerList",customerService.findCustomerList() );
        model.addAttribute("facilityList",facilityService.findFacilityList());
        return "/contract/contract";
    }

    @GetMapping("/present")
    public String getListCustomerPresent(@PageableDefault(size = 10) Pageable pageable, Model model){
        model.addAttribute("contractList",contractService.getCustomerPresent(pageable));
        model.addAttribute("size", pageable.getPageSize());
        return "/contract/list-present";
    }
}
