package com.example.SpringBoot_Proyecto_P3.service;

import com.example.SpringBoot_Proyecto_P3.models.Producto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class ProductoService {

    private List<Producto> productos = List.of(
            new Producto("1", "Laptop", 1200.0),
            new Producto("2", "Mouse", 25.0),
            new Producto("3", "Teclado", 45.0)
    );

    public Flux<Producto> obtenerProductos() {
        return Flux.fromIterable(productos);
    }


}
