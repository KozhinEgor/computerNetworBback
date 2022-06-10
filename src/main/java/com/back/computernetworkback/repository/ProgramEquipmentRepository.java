package com.back.computernetworkback.repository;

import com.back.computernetworkback.enity.Equipment;
import com.back.computernetworkback.enity.ProgramEquipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgramEquipmentRepository  extends JpaRepository<ProgramEquipment, Integer> {
    public List<ProgramEquipment> findAllByEquipment(Equipment e);
}
