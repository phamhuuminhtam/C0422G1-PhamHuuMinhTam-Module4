package com.furama.controller;

import com.furama.dto.FacilityDto;
import com.furama.model.facility.Facility;
import com.furama.service.facility.FacilityService;
import com.furama.service.rental_type.RentalTypeService;
import com.furama.service.service_type.ServiceTypeService;
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
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private ServiceTypeService serviceTypeService;

    @Autowired
    private RentalTypeService rentalTypeService;

    @Autowired
    private FacilityService facilityService;

    @GetMapping("")
    public String goListFacility(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> keyWord) {

        String key;

        if (keyWord.isPresent()) {
            key = keyWord.get();
        } else
            key = "";

        model.addAttribute("facilityList", facilityService.findAll(pageable,key));
        model.addAttribute("serviceType", serviceTypeService.findAll());
        model.addAttribute("rentalType", rentalTypeService.findAll());
        model.addAttribute("keyWord", key);
        model.addAttribute("size", pageable.getPageSize());
        return "/facility/list";
    }

    @GetMapping("/addForm")
    public String showFormAddNewFacility(Model model,@RequestParam Optional<String> keyWord, RedirectAttributes redirectAttributes) {
        if (keyWord.isPresent()) {
            redirectAttributes.addFlashAttribute("keyWord", keyWord);
            return "redirect:/facility/";
        }
        model.addAttribute("facilityDto", new Facility());
        model.addAttribute("serviceTypeList", serviceTypeService.findAll());
        model.addAttribute("rentalTypeList", rentalTypeService.findAll());
        return "/facility/add";
    }

    @PostMapping("addToDb")
    public String addNewFacility(@ModelAttribute @Valid FacilityDto facilityDto, BindingResult bindingResult, @RequestParam Optional<String> keyWord, RedirectAttributes redirectAttributes, Model model) {
        if (keyWord.isPresent()) {
            redirectAttributes.addFlashAttribute("keyWord", keyWord);
            return "redirect:/facility/";
        }
        new FacilityDto().validate(facilityDto,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("serviceTypeList", serviceTypeService.findAll());
            model.addAttribute("rentalTypeList", rentalTypeService.findAll());
            return "/facility/add";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/facility/";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam Optional<Integer> id, Model model,@RequestParam Optional<String> keyWord, RedirectAttributes redirectAttributes) {
        if (keyWord.isPresent()) {
            redirectAttributes.addFlashAttribute("keyWord", keyWord);
            return "redirect:/facility/";
        }
        model.addAttribute("facilityDto", facilityService.searchFacility(id.get()));
        model.addAttribute("serviceTypeList", serviceTypeService.findAll());
        model.addAttribute("rentalTypeList", rentalTypeService.findAll());
        return "/facility/edit";
    }

    @PostMapping("/edit")
    public String editFacility(@ModelAttribute @Valid FacilityDto facilityDto, BindingResult bindingResult,@RequestParam Optional<String> keyWord, RedirectAttributes redirectAttributes, Model model) {
        if (keyWord.isPresent()) {
            redirectAttributes.addFlashAttribute("keyWord", keyWord);
            return "redirect:/facility/";
        }
        new FacilityDto().validate(facilityDto,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("serviceTypeList", serviceTypeService.findAll());
            model.addAttribute("rentalTypeList", rentalTypeService.findAll());
            return "/facility/edit";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("message", "Sửa thông tin thành công");
        return "redirect:/facility/";
    }

    @PostMapping("/delete")
    public String deleteFacility(@RequestParam Integer id, RedirectAttributes redirectAttributes){
        facilityService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công");
        return "redirect:/facility/";
    }
}
