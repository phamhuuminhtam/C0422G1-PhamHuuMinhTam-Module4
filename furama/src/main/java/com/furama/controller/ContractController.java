package com.furama.controller;

import com.furama.dto.ContractAddDto;
import com.furama.model.contract.Contract;
import com.furama.model.employee.Employee;
import com.furama.service.contract.ContractService;
import com.furama.service.customer.CustomerService;
import com.furama.service.employee.EmployeeService;
import com.furama.service.facility.FacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public String goContract(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("contractList", contractService.getContractPage(pageable));
        model.addAttribute("size",pageable.getPageSize());
        return "/contract/contract";
    }

    @PostMapping("/add")
    public String addNewContact(@ModelAttribute Contract contract){
        contractService.save(contract);
        return "redirect:/contract";
    }

    @GetMapping("/add")
    public String showAddContract(Model model){
        model.addAttribute("customerList",customerService.findCustomerList() );
        model.addAttribute("facilityList",facilityService.findFacilityList());
        model.addAttribute("employeeList",employeeService.findAll());
        model.addAttribute("contract",new Contract());
        return "/contract/add";
    }

    @GetMapping("/present")
    public String getListCustomerPresent(@PageableDefault(size = 10) Pageable pageable, Model model){
        model.addAttribute("contractList",contractService.getCustomerPresent(pageable));
        model.addAttribute("size", pageable.getPageSize());
        return "/contract/list-present";
    }
}
