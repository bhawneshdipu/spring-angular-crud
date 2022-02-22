package com.bhawnesh.angular.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenericController {
    @GetMapping("${com.bhawnesh.angular.crud.config.ui.path:/ui}")
    public String index() {
        return "redirect:/ui/index.html";
    }
}
