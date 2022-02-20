package com.bhawnesh.angular.crud.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class GenericModel {
    String name;
    Class<Object> cls;
    Map<String,GenericModelProperty> propertyMap;
}
