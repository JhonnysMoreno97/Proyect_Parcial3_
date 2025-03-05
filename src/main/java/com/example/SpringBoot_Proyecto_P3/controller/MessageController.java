package com.example.SpringBoot_Proyecto_P3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/v1")
public class MessageController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/saludos")
    public String index(@RequestParam(name = "Accept-Language", required = false) String acceptLanguage) {
        Locale locale = extractLocaleFromHeader(acceptLanguage);
        return messageSource.getMessage("saludo", null, locale);
    }

    @GetMapping("/privado")
    public String index2(@RequestParam(name = "Accept-Language", required = false) String acceptLanguage) {
        Locale locale = extractLocaleFromHeader(acceptLanguage);
        return messageSource.getMessage("saludo", null, locale);
    }


    private Locale extractLocaleFromHeader(String acceptLanguage) {
        if (acceptLanguage == null || acceptLanguage.isEmpty()) {
            return Locale.getDefault(); // Usar el Locale por defecto si no se proporciona el encabezado
        }

        // Toma la primera parte del encabezado (el primer idioma)
        String[] languages = acceptLanguage.split(",");
        String primaryLanguage = languages[0].split(";")[0].trim();
        return Locale.forLanguageTag(primaryLanguage);
    }
}
