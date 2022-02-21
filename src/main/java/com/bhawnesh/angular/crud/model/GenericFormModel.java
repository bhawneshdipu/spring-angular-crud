package com.bhawnesh.angular.crud.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GenericFormModel {
    String name;
    String type;
    Boolean required;
    List<String> validators;
}
