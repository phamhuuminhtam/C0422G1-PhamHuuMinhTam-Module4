package com.furama.controller;

import com.furama.dto.CustomerDto;
import com.furama.model.customer.Customer;
import com.furama.service.customer.CustomerService;
import com.furama.service.guest_type.GuestTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private GuestTypeService guestTypeService;

    @GetMapping(value = {""})
    public String goListCustomer(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> keyWord) {
        String key;

        if (keyWord.isPresent()) {
            key = keyWord.get();
        } else
            key = "";
        model.addAttribute("customerList", customerService.findAll(key, pageable));
        model.addAttribute("size", pageable.getPageSize());
        model.addAttribute("keyWord", key);
        return "/customer/list";
    }

    @GetMapping("/addForm")
    public String goAddFormCustomer(Model model,@RequestParam Optional<String> keyWord, RedirectAttributes redirectAttributes) {
        if (keyWord.isPresent()) {
            redirectAttributes.addFlashAttribute("keyWord", keyWord);
            return "redirect:/customer/";
        }

        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("guestTypeList", guestTypeService.findAll());
        return "/customer/add";
    }

    @PostMapping("/add")
    public String addNewCustomer(@ModelAttribute @Valid CustomerDto customerDto, BindingResult bindingResult, @RequestParam Optional<String> keyWord, RedirectAttributes redirectAttributes, Model model) {
        if (keyWord.isPresent()) {
            redirectAttributes.addFlashAttribute("keyWord", keyWord);
            return "redirect:/customer/";
        }
        if (bindingResult.hasErrors()) {
                     model.addAttribute("guestTypeList", guestTypeService.findAll());
            return "/customer/add";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/customer/";
    }

    @GetMapping("/edit")
    public String showEditCustomerForm(@RequestParam Optional<Integer> id, Model model,@RequestParam Optional<String> keyWord, RedirectAttributes redirectAttributes) {
        if (keyWord.isPresent()) {
            redirectAttributes.addFlashAttribute("keyWord", keyWord);
            return "redirect:/customer/";
        }

        model.addAttribute("customerDto", customerService.findById(id.get()));
        model.addAttribute("guestTypeList", guestTypeService.findAll());
        return "/customer/edit";
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute @Valid CustomerDto customerDto,BindingResult bindingResult ,@RequestParam Optional<String> keyWord, RedirectAttributes redirectAttributes, Model model) {
        if (keyWord.isPresent()) {
            redirectAttributes.addFlashAttribute("keyWord", keyWord);
            return "redirect:/customer/";
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("guestTypeList", guestTypeService.findAll());
            return "/customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Sửa thông tin thành công");
        return "redirect:/customer/";
    }


    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công");
        return "redirect:/customer/";
    }



}
