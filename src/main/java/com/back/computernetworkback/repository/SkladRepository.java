package com.back.computernetworkback.repository;

import com.back.computernetworkback.enity.Component;
import com.back.computernetworkback.enity.Sklad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkladRepository extends JpaRepository<Sklad, Integer> {
    List<Sklad> findAllByNumberAfter(Integer a);

    List<Sklad> findAllByComponent(Component c);
}
