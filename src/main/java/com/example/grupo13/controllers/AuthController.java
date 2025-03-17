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
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@RequestParam String username, @RequestParam String email,
            @RequestParam String password, Model model) {
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setEmail(email);
        usuario.setPassword(password);
        userService.registerUser(usuario);
        model.addAttribute("message", "Usuario registrado exitosamente");
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(password);
        if (userService.login(usuario)) {
            // Login correcto
            return "redirect:/";
        } else {
            // Login incorrecto
            model.addAttribute("message", "Usuario o contraseña incorrectos");
            return "login";
        }
    }
}