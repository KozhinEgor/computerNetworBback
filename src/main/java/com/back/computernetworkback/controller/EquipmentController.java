package com.back.computernetworkback.controller;

import com.back.computernetworkback.enity.Equipment;
import com.back.computernetworkback.enity.Otdel;
import com.back.computernetworkback.enity.User;
import com.back.computernetworkback.repository.EquipmentRepository;
import com.back.computernetworkback.service.EdidEquipment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200",maxAge = 10L)
@RequiredArgsConstructor
@Slf4j
public class EquipmentController {

    @Autowired
    private EquipmentRepository equipmentRepository;

    private final EdidEquipment edidEquipment;

    @PostMapping("/findEquipmentByOtdel")
    public List<Equipment> findEquipmentByOtdel(@RequestBody Otdel otdel){

        return equipmentRepository.findAllByOtdel(otdel);
    }

    @PostMapping("/findCountEquipmentByOtdel")
    public Integer findCountEquipmentByOtdel(@RequestBody Otdel otdel){
        return equipmentRepository.findAllByOtdel(otdel).size();
    }

    @PutMapping("/Equipment")
    public Equipment putEquipment(@RequestBody Equipment equipment){


        return equipmentRepository.save(equipment);
    }

    @PostMapping("/equipmentCreate")
    public List<Equipment> createEquipment(@RequestBody Otdel otdel){
        Equipment eq = new Equipment();
        eq.setName("Новое оборудование");
        eq.setOtdel(otdel);
        equipmentRepository.save(eq);
        return equipmentRepository.findAllByOtdel(otdel);
    }

    @PostMapping("/razobrat")
    public String razobrat (@RequestBody Equipment equipment){
        return edidEquipment.razobrat(equipment);
    }
}
