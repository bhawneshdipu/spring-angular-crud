package com.bhawnesh.angular.crud.service;

import com.bhawnesh.angular.crud.model.GenericModel;
import com.bhawnesh.angular.crud.model.GenericModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Slf4j
@Service
@Data
public class GenericRepositoryService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private GenericRepository genericRepository;

    private HashMap<String, EntityType<?>> entityTypeMap;
    private HashMap<String, GenericModel> entityModelMap;


    public Object save(EntityType<?> entity,Object obj) {
        return genericRepository.getRepository(entity).save(obj);
    }

    public java.util.List<Object> findAll(EntityType<?> entity) {
        return genericRepository.getRepository(entity).findAll();
    }
    public Object findAllId(EntityType<?> entity,Object id) {
        return genericRepository.getRepository(entity).findById(id);
    }

    public void delete(EntityType<?> entity,Object obj) {
        genericRepository.getRepository(entity).delete(obj);
    }

    @PostConstruct
    public void init() {
        entityTypeMap = new HashMap<>();
        Set<EntityType<?>> allEntity = entityManager.getMetamodel().getEntities();
        for (EntityType<?> entity : allEntity) {
            entityTypeMap.put(entity.getName(), entity);
        }
        entityModelMap = new HashMap<>();
        for (Entry<String, EntityType<?>> entityType : entityTypeMap.entrySet()) {
            Set<SingularAttribute<?, ?>> attributes = (Set<SingularAttribute<?, ?>>) entityType.getValue().getSingularAttributes();
            GenericModel genericModel = new GenericModel();
            genericModel.setName(entityType.getKey());
            genericModel.setCls((Class<Object>) entityType.getValue().getJavaType());
            Map<String, GenericModelProperty> genericModelPropertyMap = new HashMap<>();
            for (SingularAttribute attribute : attributes) {
                GenericModelProperty modelProperty = GenericModelProperty.builder()
                        .name(attribute.getName())
                        .cls((Class<Object>) attribute.getJavaMember().getDeclaringClass())
                        .bindingType(attribute.getBindableJavaType())
                        .build();
                genericModelPropertyMap.put(attribute.getName(),modelProperty);
                log.info("{}:{}:{}:{}", attribute.getName(), attribute.getBindableJavaType(), attribute.getDeclaringType(), attribute.getJavaMember());
            }
            genericModel.setPropertyMap(genericModelPropertyMap);
            entityModelMap.put(entityType.getKey(), genericModel);
        }
        log.info("Init complete for all Entity:{}", entityModelMap);
    }
}