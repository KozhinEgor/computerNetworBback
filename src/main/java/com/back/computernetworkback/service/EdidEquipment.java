package com.back.computernetworkback.service;

import com.back.computernetworkback.enity.ComponentEquipment;
import com.back.computernetworkback.enity.Equipment;
import com.back.computernetworkback.enity.ProgramEquipment;
import com.back.computernetworkback.repository.ComponentEquipmentRepository;
import com.back.computernetworkback.repository.EquipmentRepository;
import com.back.computernetworkback.repository.ProgramEquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EdidEquipment {
    @Autowired
    ComponentEquipmentRepository componentEquipmentRepository;

    @Autowired
    ProgramEquipmentRepository programEquipmentRepository;

    @Autowired
    EquipmentRepository equipmentRepository;

    private final EditComponent editComponent;

    @Transactional
    public String razobrat(Equipment equipment){
        List<ComponentEquipment> componentEquipmentList = componentEquipmentRepository.findAllByEquipment(equipment);
        for(ComponentEquipment componentEquipment : componentEquipmentList){
            editComponent.deletecomponentEquipment(componentEquipment);
        }
        List<ProgramEquipment> programEquipments = programEquipmentRepository.findAllByEquipment(equipment);
        programEquipmentRepository.deleteAll(programEquipments);

        equipmentRepository.delete(equipment);
        return "Разобрал" + equipment.getCategory_equipment().getName() +" "+equipment.getName();
    }
}
