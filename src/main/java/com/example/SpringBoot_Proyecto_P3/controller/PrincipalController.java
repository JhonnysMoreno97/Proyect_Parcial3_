package com.example.SpringBoot_Proyecto_P3.controller;

import com.example.SpringBoot_Proyecto_P3.Repository.AuthUserRepository;
import com.example.SpringBoot_Proyecto_P3.models.AuthUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@AllArgsConstructor
public class PrincipalController {

    private final AuthUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private MessageSource messageSource;

    @PostMapping("/registro")
    public ResponseEntity registerUser (@RequestBody AuthUser authUser){
        try{
            if (userRepository.findByUsername(authUser.getUsername()).isPresent())
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already taken. Please try again");
            authUser.setPassword(passwordEncoder.encode(authUser.getPassword()));
            AuthUser save = userRepository.save(authUser);
            return ResponseEntity.ok(HttpStatus.CREATED);
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    // Endpoint público con internacionalización
    @GetMapping("/saludos")
    public String publico(@RequestParam(name = "lang", defaultValue = "en") String lang) {
        System.out.println("Hola Bienvenido ");
        Locale locale = new Locale(lang);
        return messageSource.getMessage("saludo", null, locale);
    }



    // Endpoint privado con internacionalización
    @GetMapping("/privado")
    public String privado(@RequestParam(name = "lang", defaultValue = "en") String lang) {
        Locale locale = new Locale(lang);
        return messageSource.getMessage("saludo", null, locale);
    }

}
