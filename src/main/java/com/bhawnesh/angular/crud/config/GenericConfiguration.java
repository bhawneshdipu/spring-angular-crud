package com.bhawnesh.angular.crud.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ComponentScan({"com.bhawnesh.angular.crud.*"})
public class GenericConfiguration {

    @Value("${com.bhawnesh.angular.crud.config.ui.path:/ui}")
    private String basePath;


}
