package com.example.SpringBoot_Proyecto_P3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class TestController {
    @GetMapping("/test")
    public String greeting() {
        return "Hello World!";
    }
}
