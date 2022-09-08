package com.furama.controller;

import com.furama.model.employee.Employee;
import com.furama.service.division.DivisionService;
import com.furama.service.education.EducationDegreeService;
import com.furama.service.employee.EmployeeService;
import com.furama.service.position.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String goListEmployee(Model model) {
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("educationList", educationDegreeService.findAll());
        model.addAttribute("position", positionService.findAll());
        model.addAttribute("employeeAdd", new Employee());
        return "employee/list";
    }


    @PostMapping("/add")
    public String addNewEmployee(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
        try {
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        } catch (Exception e) {
            System.out.println("lỗi");
        }
        return "redirect:/employee/";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        try {
            employeeService.delete(id);
            redirectAttributes.addFlashAttribute("message", "Xóa thành công");
        } catch (Exception e) {
            System.out.println("lỗi");
        }
        return "redirect:/employee/";
    }

    @GetMapping("/edit")
    public String editShowModal(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("employeeEdit", employeeService.findById(id));
        redirectAttributes.addFlashAttribute("edit", "edit");
        return "redirect:/employee/";
    }

    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute Employee employeeEdit, RedirectAttributes redirectAttributes) {
        try {
            employeeService.save(employeeEdit);
            redirectAttributes.addFlashAttribute("message", "Sửa thông tin thành công");
        } catch (Exception e) {
            System.out.println("lỗi");
        }
        return "redirect:/employee/";
    }
}
