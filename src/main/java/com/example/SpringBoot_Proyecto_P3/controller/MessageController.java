package com.example.SpringBoot_Proyecto_P3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Locale;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    private MessageSource messageSource;


    @GetMapping("/saludos")
    public Mono<String> obtenerSaludo(@RequestHeader(name = "Accept-Language",
            required = false) String acceptLanguage) {
        return Mono.just(messageSource.getMessage("saludo", null, LocaleContextHolder.getLocale()));

    }

    @GetMapping("/privado")
    public Mono<String> index2(@RequestHeader(name = "Accept-Language",
            required = false) String acceptLanguage) {
        return Mono.just(messageSource.getMessage("saludo", null, LocaleContextHolder.getLocale()));

    }

//    @GetMapping("/privado")
//    public String index2(@RequestParam(name = "Accept-Language", required = false) String acceptLanguage) {
//        Locale locale = extractLocaleFromHeader(acceptLanguage);
//        return messageSource.getMessage("saludo", null, locale);
//    }


//    private Locale extractLocaleFromHeader(String acceptLanguage) {
//        if (acceptLanguage == null || acceptLanguage.isEmpty()) {
//            return Locale.getDefault(); // Usar el Locale por defecto si no se proporciona el encabezado
//        }
//
//        // Toma la primera parte del encabezado (el primer idioma)
//        String[] languages = acceptLanguage.split(",");
//        String primaryLanguage = languages[0].split(";")[0].trim();
//        return Locale.forLanguageTag(primaryLanguage);
//    }
}
