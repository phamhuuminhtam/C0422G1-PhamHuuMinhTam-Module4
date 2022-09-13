package com.furama.controller;


import com.furama.model.ContractDetail;
import com.furama.service.contractdetail.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ContractDetailRestController {

    @Autowired
    private ContractDetailService contractDetailService;

    @PostMapping("/addCD")
    public ResponseEntity<Void> addNewContractDetail(@RequestBody List<ContractDetail> contractDetailList){

        contractDetailService.save(contractDetailList);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
