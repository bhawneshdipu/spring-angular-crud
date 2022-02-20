package com.bhawnesh.angular.crud.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class GenericModelProperty {
    String name;
    Class<Object> cls;
    Class<Object> bindingType;
}
