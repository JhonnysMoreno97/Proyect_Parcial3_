package com.example.SpringBoot_Proyecto_P3.service;


import com.example.SpringBoot_Proyecto_P3.Repository.AuthUserRepository;
import com.example.SpringBoot_Proyecto_P3.models.AuthUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementación personalizada de la interfaz UserDetailsService.
 * Se utiliza para cargar los detalles de un usuario desde el repositorio de usuarios.
 */

@Builder
@Service
@AllArgsConstructor
public class AuthUserDetailsService implements UserDetailsService {

    private final AuthUserRepository userRepository; // Repositorio para acceder a los usuarios en la base de datos

    /**
     * Carga un usuario por su nombre de usuario.
     * username El nombre de usuario para buscar.
     * return Los detalles del usuario si se encuentra.
     * throws UsernameNotFoundException Si no se encuentra un usuario con el nombre de usuario proporcionado.
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        // Buscar usuario en el repositorio por nombre de usuario (se convierte a minúsculas para evitar problemas de case-sensitivity)
        Optional<AuthUser> authUser  = userRepository.findByUsername(username.toLowerCase());

        // Si no se encuentra el usuario, se lanza una excepción
        if (!authUser.isPresent()){
            throw new UsernameNotFoundException(username);
        } else {
            // Si se encuentra el usuario, se retorna un objeto User con los detalles del usuario
            return User.builder()
                    .username(authUser.get().getUsername())
                    .password(authUser.get().getPassword())
                    .disabled(!authUser.get().isActive())
                    .build();
        }
    }

}
