package com.example.grupo13.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.grupo13.models.Usuario;
import com.example.grupo13.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario registerUser(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return userRepository.save(usuario);
    }

    public Optional<Usuario> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<Usuario> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean login(Usuario usuario) {
        Optional<Usuario> usuarioFromDb = findByUsername(usuario.getUsername());
        if (usuarioFromDb.isPresent()) {
            return passwordEncoder.matches(usuario.getPassword(), usuarioFromDb.get().getPassword());
        }
        return false;
    }
}