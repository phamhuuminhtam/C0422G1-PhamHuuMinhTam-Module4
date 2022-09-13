package com.furama.controller;

import com.furama.model.AttachFacility;
import com.furama.service.attachfacility.AttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class AttachFacilityRestController {

    @Autowired
    private AttachFacilityService attachFacilityService;

    @GetMapping("/AttachFacility")
    public ResponseEntity<List<AttachFacility>> getListAttachFacility(){
        List<AttachFacility> attachFacilityList= attachFacilityService.findAll();
        if(attachFacilityList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(attachFacilityList, HttpStatus.OK);
    }
}
