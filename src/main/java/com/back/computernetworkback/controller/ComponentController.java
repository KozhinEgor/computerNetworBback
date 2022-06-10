package com.back.computernetworkback.controller;

import com.back.computernetworkback.enity.Component;
import com.back.computernetworkback.enity.Sklad;
import com.back.computernetworkback.repository.ComponentRepository;
import com.back.computernetworkback.repository.SkladRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
