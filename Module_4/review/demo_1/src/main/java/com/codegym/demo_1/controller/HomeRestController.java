package com.codegym.demo_1.controller;

import com.codegym.demo_1.model.Information;
import com.codegym.demo_1.repository.IInformationRepository;
import com.codegym.demo_1.service.ICategoryService;
import com.codegym.demo_1.service.IInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/information")
public class HomeRestController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IInformationService informationService;

    @GetMapping("")
    public ResponseEntity<Page<Information>> findAll(@PageableDefault(value = 5) Pageable pageable) {
        Page<Information> informationList = informationService.findAll(pageable);
        if (informationList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(informationList, HttpStatus.OK);
        }
    }
}
