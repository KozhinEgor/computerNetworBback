package com.back.computernetworkback.service;

import com.back.computernetworkback.enity.ComponentEquipment;
import com.back.computernetworkback.enity.Sklad;
import com.back.computernetworkback.repository.ComponentEquipmentRepository;
import com.back.computernetworkback.repository.ComponentRepository;
import com.back.computernetworkback.repository.SkladRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EditComponent {
    @Autowired
    private ComponentRepository componentRepository;

    @Autowired
    private ComponentEquipmentRepository componentEquipmentRepository;

    @Autowired
    private SkladRepository skladRepository;
    @Transactional
    public List<ComponentEquipment> addEqComp (ComponentEquipment componentEquipment){
        List<Sklad> element = skladRepository.findAllByComponent(componentEquipment.getComp());
        if(element.size() > 1){
            for(int i = 1; i<element.size(); i++){
                element.get(0).setNumber(element.get(0).getNumber()+element.get(i).getNumber());
                skladRepository.delete(element.get(i));
            }
            skladRepository.save(element.get(0));
        }
        else if(element.size() == 0){
            return null;
        }
        if(element.get(0).getNumber() < componentEquipment.getNumber()){
            return null;
        }
        else if(element.get(0).getNumber() - componentEquipment.getNumber() == 0){
            skladRepository.delete(element.get(0));
        }
        else{
            element.get(0).setNumber(element.get(0).getNumber()-componentEquipment.getNumber());
            skladRepository.save(element.get(0));
        }
        List<ComponentEquipment> componentEquipmentList = componentEquipmentRepository.findAllByEquipmentAndComp(componentEquipment.getEquipment(),componentEquipment.getComp());
        if(componentEquipmentList.size() >= 1){
            for(int i = 1; i<componentEquipmentList.size(); i++){
                componentEquipmentList.get(0).setNumber(componentEquipmentList.get(0).getNumber()+componentEquipmentList.get(i).getNumber());
                componentEquipmentRepository.delete(componentEquipmentList.get(i));
            }
            componentEquipmentList.get(0).setNumber(componentEquipmentList.get(0).getNumber() + componentEquipment.getNumber());
            componentEquipmentRepository.save(componentEquipmentList.get(0));
        }
        else {
            componentEquipment.setId(null);
            componentEquipmentRepository.save(componentEquipment);
        }

        return componentEquipmentRepository.findAllByEquipment(componentEquipment.getEquipment());
    }

    @Transactional
    public List<ComponentEquipment> deletecomponentEquipment(ComponentEquipment componentEquipment){
        List<Sklad> element = skladRepository.findAllByComponent(componentEquipment.getComp());
        if(element.size() > 1){
            for(int i = 1; i<element.size(); i++){
                element.get(0).setNumber(element.get(0).getNumber()+element.get(i).getNumber());
                skladRepository.delete(element.get(i));
            }
            skladRepository.save(element.get(0));
        }
        else if(element.size() == 0){
            Sklad sklad = new Sklad();
            sklad.setComponent(componentEquipment.getComp());
            sklad.setNumber(componentEquipment.getNumber());
            skladRepository.save(sklad);
        }
        else{
            element.get(0).setNumber(element.get(0).getNumber() + componentEquipment.getNumber());
        }
        componentEquipmentRepository.delete(componentEquipment);
        return componentEquipmentRepository.findAllByEquipment(componentEquipment.getEquipment());
    }
}
