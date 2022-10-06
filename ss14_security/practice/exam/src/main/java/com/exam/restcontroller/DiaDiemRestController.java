package com.exam.restcontroller;

import com.exam.model.DiaDiem;
import com.exam.service.DiaDiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DiaDiemRestController {
    @Autowired
    private DiaDiemService diaDiemService;

    @GetMapping("/diaDiem")
    public ResponseEntity<List<DiaDiem>> findAll(){
        return new ResponseEntity<>(diaDiemService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/diaDiem/{id}")
    public ResponseEntity<DiaDiem> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(diaDiemService.findById(id),HttpStatus.OK);
    }
}
