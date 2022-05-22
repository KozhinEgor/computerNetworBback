package com.back.computernetworkback.controller;

import com.back.computernetworkback.enity.Otdel;
import com.back.computernetworkback.repository.OtdelRepository;
import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OtdelController {

    @Autowired
    private OtdelRepository otdelRepository;

    @GetMapping("/allOtdels")
    public List<Otdel> allOtdels(){
        return otdelRepository.findAll();
    }
}
