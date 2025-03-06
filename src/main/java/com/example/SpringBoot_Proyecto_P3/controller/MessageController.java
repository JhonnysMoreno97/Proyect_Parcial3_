package com.example.SpringBoot_Proyecto_P3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Locale;

// Indica que esta clase es un controlador REST en Spring WebFlux
@RestController
@RequestMapping("/api") // Define un prefijo común para las rutas del controlador

public class MessageController {

    @Autowired
    private MessageSource messageSource; // Inyección del servicio para la gestión de mensajes internacionalizados (i18n)

    /**
     * Endpoint público que retorna un saludo en el idioma especificado en la cabecera "Accept-Language".
     *
     * @param acceptLanguage (Opcional) Cabecera HTTP que especifica el idioma preferido del usuario.
     * @return Un saludo localizado basado en los archivos de mensajes de i18n.
     */

    @GetMapping("/saludos")
    public Mono<String> obtenerSaludo(@RequestHeader(name = "Accept-Language",
            required = false) String acceptLanguage) {
        // Retorna el mensaje "saludo" del archivo de propiedades según el idioma del contexto actual
        return Mono.just(messageSource.getMessage("saludo", null, LocaleContextHolder.getLocale()));

    }

    /**
     * Endpoint privado que también retorna un saludo, pero requiere autenticación.
     *
     * @param acceptLanguage (Opcional) Cabecera HTTP que especifica el idioma preferido del usuario.
     * @return Un saludo localizado
     */

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
