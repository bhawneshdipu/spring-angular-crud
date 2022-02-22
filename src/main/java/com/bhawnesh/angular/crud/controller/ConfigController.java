package com.bhawnesh.angular.crud.controller;

import com.bhawnesh.angular.crud.config.GenericConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ui-config")
public class ConfigController {
    @Autowired
    private GenericConfiguration genericConfiguration;

    @GetMapping("/base-path")
    public String basepath() {
        return genericConfiguration.getBasePath();
    }

}
