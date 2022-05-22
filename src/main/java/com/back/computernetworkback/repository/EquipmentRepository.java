package com.back.computernetworkback.repository;

import com.back.computernetworkback.enity.Equipment;
import com.back.computernetworkback.enity.Otdel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

    List<Equipment> findAllByOtdel(Otdel otdel);
}
