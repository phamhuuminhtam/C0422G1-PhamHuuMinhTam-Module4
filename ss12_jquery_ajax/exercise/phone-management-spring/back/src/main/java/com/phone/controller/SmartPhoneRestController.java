package com.phone.controller;

import com.phone.model.SmartPhone;
import com.phone.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SmartPhoneRestController {
    @Autowired
    private SmartPhoneService smartPhoneService;

    @GetMapping("/")
    public ResponseEntity<List<SmartPhone>> goList() {
        List<SmartPhone> smartPhoneList = smartPhoneService.findAll();
        if (smartPhoneList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartPhoneList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createNewPhone(@RequestBody SmartPhone smartPhone) {
        smartPhoneService.save(smartPhone);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<Void> updatePhone(@RequestBody SmartPhone smartPhone) {
        smartPhoneService.save(smartPhone);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deletePhone(@RequestParam Long id) {
        try {
            smartPhoneService.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<SmartPhone> findSmartPhone(@RequestParam Long id) {
        SmartPhone smartPhone = smartPhoneService.findById(id);
        if (smartPhone == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(smartPhone,HttpStatus.OK);
    }
}
