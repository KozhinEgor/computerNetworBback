package com.back.computernetworkback.repository;

import com.back.computernetworkback.enity.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class ComponentRepositorImpl extends SimpleJpaRepository<Component,Integer> implements ComponentRepository{

    private final EntityManager entityManager;
    @Autowired
    private SkladRepository sklad;

    public ComponentRepositorImpl(EntityManager entityManager) {
        super(Component.class,entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public List<Component> findFreeComponent() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Component> query = builder.createQuery(Component.class);
        Root<Component> programKeyRoot = query.from(Component.class);
        Predicate predicates =programKeyRoot.get("id").in(sklad.findAllByNumberAfter(0).stream().map(b -> b.getComponent().getId()).collect(Collectors.toList()));
        query.select(programKeyRoot).where(predicates);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Component> findComponentNoSklad() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Component> query = builder.createQuery(Component.class);
        Root<Component> programKeyRoot = query.from(Component.class);
        Predicate predicates =programKeyRoot.get("id").in(sklad.findAll().stream().map(b -> b.getComponent().getId()).collect(Collectors.toList())).not();
        query.select(programKeyRoot).where(predicates);
        return entityManager.createQuery(query).getResultList();
    }
}
