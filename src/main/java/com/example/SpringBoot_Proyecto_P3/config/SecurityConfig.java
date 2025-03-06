package com.example.SpringBoot_Proyecto_P3.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.DelegatingFilterProxyRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//Aquí se configura la cadena de filtros de seguridad para la aplicación.

@Configuration
@EnableAutoConfiguration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity, DelegatingFilterProxyRegistrationBean sessionRepositoryFilterRegistration) throws Exception {
        return httpSecurity
                // Deshabilita la protección CSRF (Cross-Site Request Forgery)
                .csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(auth-> {
                        auth.requestMatchers("/api/saludos","/v1/test","/registro","/error","/api/productos","api/example").permitAll() // Permite el acceso sin autenticación a estas rutas
                                .requestMatchers("api/privado").authenticated(); // Requiere autenticación para esta ruta
                               // .anyRequest().authenticated();
                })
                // Habilita el formulario de inicio de sesión con acceso permitido a todos
                .formLogin().permitAll()
                .and()
                .httpBasic()     // Habilita la autenticación básica HTTP
                .and()
                .sessionManagement()   // Configuración de gestión de sesiones (puede expandirse según la necesidad)
                .and()
                .httpBasic(Customizer.withDefaults())  // Configura autenticación HTTP básica y formulario de inicio de sesión con valores por defecto
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .build(); // Construye la configuración de seguridad
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
