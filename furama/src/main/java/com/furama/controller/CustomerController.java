package com.furama.controller;

import com.furama.model.customer.Customer;
import com.furama.model.facility.Facility;
import com.furama.service.customer.CustomerService;
import com.furama.service.guest_type.GuestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private GuestTypeService guestTypeService;

    @GetMapping("")
    public String goListCustomer(Model model){
        model.addAttribute("customerList",customerService.findAll());
        return "/customer/list";
    }

    @GetMapping("/addForm")
    public String goAddFormCustomer(Model model){
        model.addAttribute("customer",new Customer());
        model.addAttribute("guestTypeList",guestTypeService.findAll());
        return "/customer/add";
    }

    @PostMapping("/add")
    public String addNewCustomer(@ModelAttribute Customer customer){
        customerService.save(customer);
        return "redirect:/customer/";
    }

    @GetMapping("/edit")
    public String showEditCustomerForm(@RequestParam Integer id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("guestTypeList",guestTypeService.findAll());
        return "/customer/edit";
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customer/";
    }


    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam Integer id){
        customerService.delete(id);
        return "redirect:/customer/";
    }

}
