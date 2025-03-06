package com.example.SpringBoot_Proyecto_P3.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class LocateConfig {

    @Bean
    public MessageSource messageSource() {

        ReloadableResourceBundleMessageSource messageSource = new
                ReloadableResourceBundleMessageSource();
        // Define la ubicación base de los archivos de mensajes (sin la extensión .properties)
        messageSource.setBasename("classpath:messages");
        // Especifica la codificación de caracteres para evitar problemas con caracteres especiales
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;

    }

}
