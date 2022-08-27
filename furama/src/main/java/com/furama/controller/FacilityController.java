package com.furama.controller;

import com.furama.model.facility.Facility;
import com.furama.service.facility.FacilityService;
import com.furama.service.rental_type.RentalTypeService;
import com.furama.service.service_type.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private ServiceTypeService serviceTypeService;

    @Autowired
    private RentalTypeService rentalTypeService;

    @Autowired
    private FacilityService facilityService;

    @GetMapping("")
    public String goListFacility(Model model) {
        model.addAttribute("facilityList", facilityService.findAll());
        model.addAttribute("serviceType", serviceTypeService.findAll());
        model.addAttribute("rentalType", rentalTypeService.findAll());
        return "/facility/list";
    }

    @GetMapping("/addForm")
    public String showFormAddNewFacility(Model model) {
        model.addAttribute("facility", new Facility());
        model.addAttribute("serviceTypeList", serviceTypeService.findAll());
        model.addAttribute("rentalTypeList", rentalTypeService.findAll());
        return "/facility/add";
    }

    @PostMapping("addToDb")
    public String addNewFacility(@ModelAttribute Facility facility) {
        facilityService.save(facility);
        return "redirect:/facility/";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam Integer id, Model model) {
        model.addAttribute("facility", facilityService.searchFacility(id));
        model.addAttribute("serviceTypeList", serviceTypeService.findAll());
        model.addAttribute("rentalTypeList", rentalTypeService.findAll());
        return "/facility/edit";
    }

    @PostMapping("/edit")
    public String editFacility(@ModelAttribute Facility facility) {
        facilityService.save(facility);
        return "redirect:/facility/";
    }

    @PostMapping("/delete")
    public String deleteFacility(@RequestParam Integer id){
        facilityService.delete(id);
        return "redirect:/facility/";
    }
}
