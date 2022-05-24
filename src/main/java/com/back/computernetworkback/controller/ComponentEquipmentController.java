package com.back.computernetworkback.controller;

import com.back.computernetworkback.enity.ComponentEquipment;
import com.back.computernetworkback.enity.Equipment;
import com.back.computernetworkback.repository.ComponentEquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ComponentEquipmentController {

    @Autowired
    ComponentEquipmentRepository componentEquipmentRepository;

    @PostMapping("/findAllByEquipment")
    List<ComponentEquipment> findAllByEquipment (@RequestBody Equipment equipment){
        return componentEquipmentRepository.findAllByEquipment(equipment);
    }
    @PostMapping("/addEqComp")
    List<ComponentEquipment> addEqComp (@RequestBody ComponentEquipment componentEquipment){
        componentEquipment.setId(null);
        componentEquipmentRepository.save(componentEquipment);
        return componentEquipmentRepository.findAllByEquipment(componentEquipment.getEquipment());
    }
    @PostMapping("/deletecomponentEquipment")
    List<ComponentEquipment> deletecomponentEquipment (@RequestBody ComponentEquipment componentEquipment){
        componentEquipmentRepository.delete(componentEquipment);
        return componentEquipmentRepository.findAllByEquipment(componentEquipment.getEquipment());
    }
}
