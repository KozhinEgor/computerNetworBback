package com.back.computernetworkback.controller;

import com.back.computernetworkback.enity.*;
import com.back.computernetworkback.repository.CategoryComponentRepository;
import com.back.computernetworkback.repository.ComponentRepository;
import com.back.computernetworkback.repository.SkladRepository;
import com.back.computernetworkback.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ComponentController {
    @Autowired
    private ComponentRepository componentRepository;

    @Autowired
    private SkladRepository skladRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private CategoryComponentRepository categoryComponentRepository;

//    @GetMapping("findAllFreeComponents")
//    public List<Component> findAllFreeComponents(){
//       Query
//    }
    @GetMapping("/findAllComponent")
    public List<Component> findAllFreeComponents(){
       return componentRepository.findAll();
    }

    @GetMapping("/findFreeComponent")
    public List<Sklad> findFreeComponent(){
        return skladRepository.findAll();
    }

    @GetMapping("/findComponentNoSklad")
    public List<Component> findComponentNoSklad(){
        return componentRepository.findComponentNoSklad();
    }
    @PostMapping("/addToSklad")
    public Sklad addToSklad(@RequestBody Component component){
        Sklad sklad = new Sklad();
        sklad.setNumber(0L);
        sklad.setComponent(component);
        return skladRepository.save(sklad);
    }

    @GetMapping("/findAllVendor")
    public List<Vendor> findAllVendor(){return vendorRepository.findAll();}

    @GetMapping("/findAllCategoryComponent")
    public List<CategoryComponent> findAllCategoryComponent(){return categoryComponentRepository.findAll();}

    @PostMapping("/saveComponent")
    public List<Component> saveComponent(@RequestBody Component component){
        componentRepository.save(component);
        return componentRepository.findAll();
    }
    @PostMapping("/updateSklad")
    public List<Sklad> updateSklad(@RequestBody Sklad sklad){
        if(sklad.getNumber() == null){
            skladRepository.delete(sklad);
        }
        else {
            skladRepository.save(sklad);
        }
        return skladRepository.findAll();
    }

    @PostMapping("/createVendor")
    public  Vendor createVendor(@RequestBody String a){
        Vendor categoryEquipment = new Vendor();
        categoryEquipment.setName(a);
        return vendorRepository.save(categoryEquipment);
    }

}
