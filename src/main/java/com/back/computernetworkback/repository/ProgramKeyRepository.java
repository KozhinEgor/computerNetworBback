package com.back.computernetworkback.repository;

import com.back.computernetworkback.enity.ProgramKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
@NoRepositoryBean
public interface ProgramKeyRepository extends JpaRepository<ProgramKey,Integer> {

    public List<ProgramKey> findFreeKey();

    List<ProgramKey> findReestr();
}
