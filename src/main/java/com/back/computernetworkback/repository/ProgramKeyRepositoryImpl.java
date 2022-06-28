package com.back.computernetworkback.repository;

import com.back.computernetworkback.enity.ProgramKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProgramKeyRepositoryImpl extends SimpleJpaRepository<ProgramKey,Integer> implements ProgramKeyRepository{

    private final EntityManager entityManager;
    @Autowired
    private ProgramEquipmentRepository findAll;

    public ProgramKeyRepositoryImpl(EntityManager entityManager) {
        super(ProgramKey.class,entityManager);
        this.entityManager = entityManager;
    }


    @Override
    public List<ProgramKey> findFreeKey() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProgramKey> query = builder.createQuery(ProgramKey.class);
        Root<ProgramKey> programKeyRoot = query.from(ProgramKey.class);
        Predicate predicates =programKeyRoot.get("id").in(findAll.findAll().stream().map(b -> b.getProgramKey().getId()).collect(Collectors.toList())).not();
        query.select(programKeyRoot).where(predicates);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<ProgramKey> findReestr(){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProgramKey> query = builder.createQuery(ProgramKey.class);
        Root<ProgramKey> programKeyRoot = query.from(ProgramKey.class);
        query.select(programKeyRoot);
        return entityManager.createQuery(query).getResultList();
    }
}
