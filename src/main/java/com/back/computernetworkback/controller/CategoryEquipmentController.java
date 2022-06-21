package com.back.computernetworkback.controller;

import com.back.computernetworkback.enity.CategoryComponent;
import com.back.computernetworkback.enity.CategoryEquipment;
import com.back.computernetworkback.repository.CategoryComponentRepository;
import com.back.computernetworkback.repository.CategoryEquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryEquipmentController {

    @Autowired
    private CategoryEquipmentRepository categoryEquipmentRepository;

    @Autowired
    private CategoryComponentRepository categoryComponentRepository;

    @GetMapping("/findAllCategoryEquipment")
    public List<CategoryEquipment> findAllCategoryEquipment(){
        return categoryEquipmentRepository.findAll();
    }

    @PostMapping("/createCatEq")
    public CategoryEquipment createCatEq(@RequestBody String a){
        CategoryEquipment categoryEquipment = new CategoryEquipment();
        categoryEquipment.setName(a);
        return categoryEquipmentRepository.save(categoryEquipment);
    }
    @PostMapping("/createComponent")
    public  CategoryComponent createComponent(@RequestBody String a){
        CategoryComponent categoryEquipment = new  CategoryComponent();
        categoryEquipment.setName(a);
        return categoryComponentRepository.save(categoryEquipment);
    }
}
