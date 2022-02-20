package com.bhawnesh.angular.crud.controller;

import com.bhawnesh.angular.crud.model.GenericModel;
import com.bhawnesh.angular.crud.model.GenericModelProperty;
import com.bhawnesh.angular.crud.service.GenericRepositoryService;
import com.bhawnesh.angular.crud.util.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.Collections;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("${com.bhawnesh.angular.crud.config.ui.path:/ui}")
public class GenericRestController {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private GenericRepositoryService genericRepositoryService;


    @GetMapping("/api/all")
    public ResponseEntity<?> allRepository() {
        log.info("{}", genericRepositoryService.getEntityModelMap());
        return ResponseEntity.ok(genericRepositoryService.getEntityModelMap());
    }

    @GetMapping("/api/list/{entity}")
    public ResponseEntity<?> listByEntity(@PathVariable("entity") String entity) {
        return ResponseEntity.ok(genericRepositoryService.findAll(genericRepositoryService.getEntityTypeMap().get(entity)));
    }

    @GetMapping("/api/find/{entity}/{id}")
    public ResponseEntity<?> findById(@PathVariable("entity") String entity,@PathVariable("id") String id) {
        EntityType<?> entityType = genericRepositoryService.getEntityTypeMap().get(entity);
        GenericModel genericModel = genericRepositoryService.getEntityModelMap().get(entity);
        GenericModelProperty genericModelProperty = genericModel.getPropertyMap().get("id");
        Object identifier = JSONUtil.toObject(id, genericModelProperty.getBindingType());
        Object instance = genericRepositoryService.getGenericRepository().findById(entityType, identifier);
        if (instance instanceof Optional && ((Optional) instance).isPresent()) {
            genericRepositoryService.delete(genericRepositoryService.getEntityTypeMap().get(entity), ((Optional<?>) instance).get());
            return ResponseEntity.ok(Collections.singletonList(instance));
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    @PostMapping("/api/save/{entity}")
    public ResponseEntity<?> savByEntity(@RequestBody Object request, @PathVariable("entity") String entity) {
        GenericModel genericModel = genericRepositoryService.getEntityModelMap().get(entity);
        EntityType<?> entityType = genericRepositoryService.getEntityTypeMap().get(entity);
        Object obj = JSONUtil.toObject(request, genericModel.getCls());
        return ResponseEntity.ok(genericRepositoryService.save(entityType, obj));
    }

    @DeleteMapping("/api/delete/{entity}/{id-attribute}/{id}")
    public ResponseEntity<?> listByEntity(@PathVariable("entity") String entityStr, @PathVariable("id-attribute") String idAttribute, @PathVariable("id") String id) {
        EntityType<?> entityType = genericRepositoryService.getEntityTypeMap().get(entityStr);
        GenericModel genericModel = genericRepositoryService.getEntityModelMap().get(entityStr);
        GenericModelProperty genericModelProperty = genericModel.getPropertyMap().get(idAttribute);
        Object identifier = JSONUtil.toObject(id, genericModelProperty.getBindingType());
        Object instance = genericRepositoryService.getGenericRepository().findById(entityType, identifier);
        if (instance instanceof Optional && ((Optional) instance).isPresent()) {
            genericRepositoryService.delete(genericRepositoryService.getEntityTypeMap().get(entityStr), ((Optional<?>) instance).get());
            return ResponseEntity.ok(instance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/delete/{entity}/{id}")
    public ResponseEntity<?> listByEntity(@PathVariable("entity") String entityStr, @PathVariable("id") String id) {
        EntityType<?> entityType = genericRepositoryService.getEntityTypeMap().get(entityStr);
        GenericModel genericModel = genericRepositoryService.getEntityModelMap().get(entityStr);
        GenericModelProperty genericModelProperty = genericModel.getPropertyMap().get("id");
        Object identifier = JSONUtil.toObject(id, genericModelProperty.getBindingType());
        Object instance = genericRepositoryService.getGenericRepository().findById(entityType, identifier);
        if (instance instanceof Optional && ((Optional) instance).isPresent()) {
            genericRepositoryService.delete(genericRepositoryService.getEntityTypeMap().get(entityStr), ((Optional<?>) instance).get());
            return ResponseEntity.ok(instance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
