package com.codegym.phone_manager.controller;

import com.codegym.phone_manager.model.Smartphone;
import com.codegym.phone_manager.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class APIPhoneController {

    @Autowired
    IPhoneService phoneService;

    @GetMapping("")
    public ResponseEntity<List<Smartphone>> getList(@RequestParam(value = "searchModel", defaultValue = "") String searchModel) {
        if (phoneService.findAll().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(phoneService.findAllByModelContainsAndStatus(searchModel, "on"), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<List<Smartphone>> createPhone(@Valid @RequestBody Smartphone smartphone) {
        smartphone.setStatus("on");
        phoneService.save(smartphone);
        return new ResponseEntity<>(phoneService.findAll(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Smartphone> findById(@PathVariable Long id) {
        return new ResponseEntity<>(phoneService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<List<Smartphone>> updatePhone(@Valid @RequestBody Smartphone smartphone) {
        smartphone.setStatus("on");
        phoneService.save(smartphone);
        return new ResponseEntity<>(phoneService.findAll(), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<List<Smartphone>> deletePhone_updateDB(@PathVariable Long id) {
        Smartphone smartphone = phoneService.findById(id);
        smartphone.setStatus("off");
        phoneService.save(smartphone);
        return new ResponseEntity<>(phoneService.findAll(), HttpStatus.OK);
    }
}
