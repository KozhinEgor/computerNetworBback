package com.back.computernetworkback.repository;

import com.back.computernetworkback.enity.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComponentRepository extends JpaRepository<Component,Integer> {

}
