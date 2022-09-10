package com.furama.controller;

import com.furama.dto.AttachServiceFree;
import com.furama.service.contract.ContractService;
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
    @GetMapping("")
    public ResponseEntity<List<AttachServiceFree>> listAttach(@RequestParam Integer idc){
        List<AttachServiceFree> attachServiceFreeList =contractService.getAttachServiceFree(idc);
        if(attachServiceFreeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else
        return new ResponseEntity<>(attachServiceFreeList, HttpStatus.OK);
    }


}
