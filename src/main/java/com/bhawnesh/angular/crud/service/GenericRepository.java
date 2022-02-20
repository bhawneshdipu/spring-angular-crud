package com.bhawnesh.angular.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.Collections;
import java.util.Optional;

@Repository
public class GenericRepository {


    @Autowired
    private ApplicationContext applicationContext;


    Repositories repositories = null;


    public JpaRepository<Object, Object> getRepository(EntityType<?> entity) {
        Optional<Object> repository = repositories.getRepositoryFor(entity.getJavaType());
        return (JpaRepository<Object, Object>) repository.orElse(null);
    }

    public Object save(EntityType<?> entity) {
        return getRepository(entity).save(entity);
    }

    public java.util.List<Object> findAll(EntityType<?> entity) {
        return getRepository(entity).findAll();
    }
    public Object findById(EntityType<?> entity,Object id) {
        return getRepository(entity).findById(id);
    }
    public void delete(EntityType<?> entity) {
        getRepository(entity).delete(entity);
    }

    @PostConstruct
    public void init() {
        repositories = new Repositories(applicationContext);
    }
}
