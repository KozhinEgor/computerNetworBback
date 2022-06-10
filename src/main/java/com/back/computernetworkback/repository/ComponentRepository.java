package com.back.computernetworkback.repository;

import com.back.computernetworkback.enity.Component;
import com.back.computernetworkback.enity.ComponentEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ComponentRepository extends JpaRepository<Component,Integer> {
    List<Component> findFreeComponent();
}
