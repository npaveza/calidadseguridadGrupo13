package com.example.grupo13.controllers;

import java.util.Optional;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.grupo13.models.Usuario;
import com.example.grupo13.services.UserService;


@Controller
public class ProfileController {

    private final EventController eventoController;

    private final AuthController authController;

    private final UserService usuarioService;

    public ProfileController(UserService usuarioService, AuthController authController, EventController eventoController) {
        this.usuarioService = usuarioService;
        this.authController = authController;
        this.eventoController = eventoController;
    }

    @GetMapping("/perfil")
    public String viewProfile(@AuthenticationPrincipal UserDetails userDetails, Model model){
        Optional<Usuario> usuario = usuarioService.findByUsername(userDetails.getUsername());
        usuario.ifPresent(value -> model.addAttribute("usuario", value));
        return "perfil";
    }

    @GetMapping("/perfil")
    public String updateProfile(@AuthenticationPrincipal UserDetails userDetails,
                                @RequestParam String avatar,
                                @RequestParam String games,
                                @RequestParam(required = false) boolean notifications){
                                    Optional<Usuario> usuarioOptional = usuarioService.findByUsername(userDetails.getUsername());
                                    if(usuarioOptional.isPresent()){
                                        Usuario usuario = usuarioOptional.get();
                                        usuario.setAvatar(avatar);
                                        usuario.setGames(games);
                                        usuario.setNotifications(notifications);
                                        usuarioService.registerUser(usuario);
                                    }
                                    return "redirect:/perfil";
                                }
    
    
}
