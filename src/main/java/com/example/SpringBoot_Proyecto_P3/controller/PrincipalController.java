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
    private MessageSource messageSource; // Inyección del servicio de internacionalización

    /**
     * Endpoint para registrar un nuevo usuario en el sistema.
     *
     * @param authUser Objeto con la información del usuario recibido en el cuerpo de la solicitud.
     * @return ResponseEntity con el estado de la operación.
     */
    @PostMapping("/registro")
    public ResponseEntity registerUser (@RequestBody AuthUser authUser){
        try{
            // Verifica si el nombre de usuario ya existe en la base de datos
            if (userRepository.findByUsername(authUser.getUsername()).isPresent())
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already taken. Please try again");
            authUser.setPassword(passwordEncoder.encode(authUser.getPassword())); // Cifra la contraseña antes de guardarla en la base de datos
            AuthUser save = userRepository.save(authUser);  // Guarda el nuevo usuario en la base de datos
            return ResponseEntity.ok(HttpStatus.CREATED);
        } catch (Exception e){ // Manejo de excepciones en caso de error
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
