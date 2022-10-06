package com.exam.restcontroller;

import com.exam.model.Xe;
import com.exam.service.XeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class XeRestController {
    @Autowired
    private XeService xeService;

    @GetMapping("")
    public ResponseEntity<Page<Xe>> getList(@PageableDefault(size = 4) Pageable pageable,@RequestParam Optional<String> key) {
        String keySearch = key.orElse("");
        if (!xeService.findAll(pageable,keySearch).hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(xeService.findAll(pageable,keySearch), HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestParam Integer id) {
        xeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Xe> findById(@RequestParam Integer id) {
        return new ResponseEntity<>(xeService.findById(id), HttpStatus.OK);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Void> edit(@PathVariable("id") Integer id, @RequestBody Xe xe){
        xeService.edit(xe);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Void> add(@RequestBody Xe xe){
        xeService.add(xe);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
