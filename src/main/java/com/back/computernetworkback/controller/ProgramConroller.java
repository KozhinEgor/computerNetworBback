package com.back.computernetworkback.controller;

import com.back.computernetworkback.enity.*;
import com.back.computernetworkback.repository.ProgramEquipmentRepository;
import com.back.computernetworkback.repository.ProgramKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProgramConroller {

    @Autowired
    private ProgramKeyRepository programKeyRepository;

    @Autowired
    private ProgramEquipmentRepository programEquipmentRepository;

    @GetMapping("/findFreeProgramKeys")
    public List<ProgramKey> findFreeProgramKeys(){

        return programKeyRepository.findFreeKey();
    }

    @PostMapping("/findAllProgramByEquipment")
    public List<ProgramEquipment> findAllProgramByEquipment(@RequestBody Equipment equipment){

        return programEquipmentRepository.findAllByEquipment(equipment);
    }

    @PostMapping("/deleteProgramEquipment")
    public List<ProgramEquipment> deleteProgramEquipment(@RequestBody ProgramEquipment programEquipment){
        programEquipmentRepository.delete(programEquipment);
        return programEquipmentRepository.findAllByEquipment(programEquipment.getEquipment());
    }
    @PostMapping("/addProgrammEq")
    List<ProgramEquipment> addProgrammEq(@RequestBody ProgramEquipment programEquipment){
        programEquipment.setId(null);
        programEquipmentRepository.save(programEquipment);
        return programEquipmentRepository.findAllByEquipment(programEquipment.getEquipment());
    }
}
