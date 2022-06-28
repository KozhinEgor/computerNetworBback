package com.back.computernetworkback.controller;

import com.back.computernetworkback.enity.*;
import com.back.computernetworkback.repository.ProgramEquipmentRepository;
import com.back.computernetworkback.repository.ProgramKeyRepository;
import com.back.computernetworkback.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProgramConroller {

    @Autowired
    private ProgramKeyRepository programKeyRepository;

    @Autowired
    private ProgramRepository programRepository;

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

    @GetMapping("/programReestr")
    List<ProgramKey> programReestr(){
            return programKeyRepository.findReestr();
    }
    @GetMapping("/programs")
    List<Program> programs(){
        return programRepository.findAll();
    }

    @PostMapping("/saveProgramKey")
    public ProgramKey saveProgram(@RequestBody ProgramKey programKey){
        if(programKey.getId() == 0){
            programKey.setId(null);
        }
        return programKeyRepository.save(programKey);
    }
    @PostMapping("/saveProgram")
    public Program addProgram(@RequestBody String name){
        Program program = new Program();
        program.setName(name);
        return programRepository.save(program);
    }
}
