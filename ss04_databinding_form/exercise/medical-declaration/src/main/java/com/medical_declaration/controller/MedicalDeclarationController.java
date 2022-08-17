package com.medical_declaration.controller;

import com.medical_declaration.model.MedicalDeclaration;
import com.medical_declaration.service.MedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MedicalDeclarationController {

    @Autowired
    private MedicalDeclarationService medicalDeclarationService;

    @GetMapping("/")
    public String goHome(Model model) {
        List<String> yearList = medicalDeclarationService.findAllYear();
        List<String> dayList = medicalDeclarationService.findAllDay();
        List<String> monthList = medicalDeclarationService.findAllMonth();
        List<String> genderList = medicalDeclarationService.findAllGender();
        List<String> nationList = medicalDeclarationService.findAllNation();
        List<String> vehicleList = medicalDeclarationService.findAllVehicle();
        model.addAttribute("MedicalDeclaration", new MedicalDeclaration());
        model.addAttribute("yearList", yearList);
        model.addAttribute("dayList", dayList);
        model.addAttribute("monthList", monthList);
        model.addAttribute("genderList", genderList);
        model.addAttribute("nationList", nationList);
        model.addAttribute("vehicleList", vehicleList);
        return "home";
    }

    @PostMapping("/form")
    public String receiveForm(@ModelAttribute MedicalDeclaration medicalDeclaration, Model model) {
        medicalDeclarationService.saveForm(medicalDeclaration);
        model.addAttribute("medicalDeclarationList", medicalDeclarationService.findAll());
        return "details";
    }

    @GetMapping("/details")
    public String showList(Model model) {
        model.addAttribute("medicalDeclarationList", medicalDeclarationService.findAll());
        return "details";
    }

    @GetMapping("/update")
    public String update(@RequestParam int id,Model model){
        List<String> yearList = medicalDeclarationService.findAllYear();
        List<String> dayList = medicalDeclarationService.findAllDay();
        List<String> monthList = medicalDeclarationService.findAllMonth();
        List<String> genderList = medicalDeclarationService.findAllGender();
        List<String> nationList = medicalDeclarationService.findAllNation();
        List<String> vehicleList = medicalDeclarationService.findAllVehicle();
        MedicalDeclaration medicalDeclaration = medicalDeclarationService.searchById(id);
        model.addAttribute("MedicalDeclaration",medicalDeclaration);
        model.addAttribute("yearList", yearList);
        model.addAttribute("dayList", dayList);
        model.addAttribute("monthList", monthList);
        model.addAttribute("genderList", genderList);
        model.addAttribute("nationList", nationList);
        model.addAttribute("vehicleList", vehicleList);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute MedicalDeclaration medicalDeclaration, @RequestParam int id){
        medicalDeclarationService.update(id,medicalDeclaration);
        return "redirect:/details";
    }

}
