package com.furama.controller;

import com.furama.service.division.DivisionService;
import com.furama.service.education.EducationDegreeService;
import com.furama.service.employee.EmployeeService;
import com.furama.service.position.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/employee")
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EducationDegreeService educationDegreeService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private DivisionService divisionService;

    @GetMapping("")
    public String goListEmployee(Model model){
        model.addAttribute("employeeList",employeeService.findAll());
        model.addAttribute("divisionList",divisionService.findAll());
        model.addAttribute("educationList",educationDegreeService.findAll());
        model.addAttribute("position",positionService.findAll());
        return "employee/list";
    }
}
