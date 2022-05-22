package com.back.computernetworkback.controller;

import com.back.computernetworkback.enity.CategoryEquipment;
import com.back.computernetworkback.repository.CategoryEquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryEquipmentController {

    @Autowired
    private CategoryEquipmentRepository categoryEquipmentRepository;

    @GetMapping("/findAllCategoryEquipment")
    public List<CategoryEquipment> findAllCategoryEquipment(){
        return categoryEquipmentRepository.findAll();
    }
}
