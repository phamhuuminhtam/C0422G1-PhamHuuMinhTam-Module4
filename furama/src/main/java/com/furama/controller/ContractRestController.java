package com.furama.controller;

import com.furama.dto.AttachServiceFree;
import com.furama.model.contract.Contract;
import com.furama.model.facility.Facility;
import com.furama.service.contract.ContractService;
import com.furama.service.facility.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contract-rest")
public class ContractRestController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private FacilityService facilityService;

    @GetMapping("")
    public ResponseEntity<List<AttachServiceFree>> listAttach(@RequestParam Integer idc){
        List<AttachServiceFree> attachServiceFreeList =contractService.getAttachServiceFree(idc);
        if(attachServiceFreeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else
        return new ResponseEntity<>(attachServiceFreeList, HttpStatus.OK);
    }

    @GetMapping("/editFacility")
    public ResponseEntity<List<Facility>> listFacilityForEdit(){
        List<Facility> facilityList = facilityService.findFacilityList();
        if(facilityList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      else   return new ResponseEntity<>(facilityList,HttpStatus.OK);
    }

    @GetMapping("/editFacilitytoDB")
    public ResponseEntity<String> editFacilityToDB(@RequestParam Integer id, @RequestParam Integer idc){
      Contract contract = contractService.findByID(idc);
      Facility facility = facilityService.searchFacility(id);
      contract.setFacility(facility);
      contractService.save(contract);
      return new ResponseEntity<>("ok",HttpStatus.OK);
    }
}
