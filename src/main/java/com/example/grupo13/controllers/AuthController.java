package com.example.grupo13.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.grupo13.models.Usuario;
import com.example.grupo13.services.UserService;

@Controller
public class AuthController {
    private final UserService usuarioService;

    public AuthController(UserService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String loguin() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@RequestParam String nombre, @RequestParam String email,
            @RequestParam String password, Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuarioService.registerUser(usuario);
        model.addAttribute("message", "Usuario registrado exitosamente");
        return "redirect:/login";
    }

}

