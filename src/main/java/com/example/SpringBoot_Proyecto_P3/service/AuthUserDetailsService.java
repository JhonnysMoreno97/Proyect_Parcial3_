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

@Builder
@Service
@AllArgsConstructor
public class AuthUserDetailsService implements UserDetailsService {

    private final AuthUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<AuthUser> authUser  = userRepository.findByUsername(username.toLowerCase());
        if (!authUser.isPresent()){
            throw new UsernameNotFoundException(username);
        } else {
            return User.builder()
                    .username(authUser.get().getUsername())
                    .password(authUser.get().getPassword())
                    .disabled(!authUser.get().isActive())
                    .build();
        }
    }

}
