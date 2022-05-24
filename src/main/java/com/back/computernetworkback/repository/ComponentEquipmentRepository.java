package com.back.computernetworkback.repository;

import com.back.computernetworkback.enity.ComponentEquipment;
import com.back.computernetworkback.enity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComponentEquipmentRepository extends JpaRepository<ComponentEquipment,Integer> {

 List<ComponentEquipment> findAllByEquipment(Equipment equipment);
}
