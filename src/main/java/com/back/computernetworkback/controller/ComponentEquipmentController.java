package com.back.computernetworkback.controller;

import com.back.computernetworkback.enity.ComponentEquipment;
import com.back.computernetworkback.enity.Equipment;
import com.back.computernetworkback.repository.ComponentEquipmentRepository;
import com.back.computernetworkback.service.EditComponent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Slf4j
public class ComponentEquipmentController {

    @Autowired
    ComponentEquipmentRepository componentEquipmentRepository;

    private final EditComponent editComponent;

    @PostMapping("/findAllByEquipment")
    List<ComponentEquipment> findAllByEquipment (@RequestBody Equipment equipment){
        return componentEquipmentRepository.findAllByEquipment(equipment);
    }
    @PostMapping("/addEqComp")
    List<ComponentEquipment> addEqComp (@RequestBody ComponentEquipment componentEquipment){
        return editComponent.addEqComp(componentEquipment);
    }
    @PostMapping("/deletecomponentEquipment")
    List<ComponentEquipment> deletecomponentEquipment (@RequestBody ComponentEquipment componentEquipment){
        return editComponent.deletecomponentEquipment(componentEquipment);
    }
}
