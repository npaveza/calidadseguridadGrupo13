package com.example.grupo13.controllers;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProfileController {
    @GetMapping("/perfil")
    public String getMethodName(Model model, Authentication authentication) {
        model.addAttribute("usuario", authentication.getUsername());
        return "perfil";
    }
    
}
