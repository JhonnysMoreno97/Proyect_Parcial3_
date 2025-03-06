package com.example.SpringBoot_Proyecto_P3.service;

import com.example.SpringBoot_Proyecto_P3.models.Producto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * Servicio encargado de la lógica de negocio relacionada con los productos.
 * Este servicio maneja una lista estática de productos y proporciona una función para obtenerlos.
 */

// Marca esta clase como un servicio para que Spring la administre como un componente.
@Service
public class ProductoService {

    // Lista estática de productos, representada por objetos de la clase Producto.
    private List<Producto> productos = List.of(
            new Producto("1", "Laptop", 1200.0),
            new Producto("2", "Mouse", 25.0),
            new Producto("3", "Teclado", 45.0)
    );

    /**
     * Método que obtiene todos los productos disponibles.
     * Devuelve un Flux, que es un tipo de publisher reactivo que emite múltiples elementos.
     *
     * @return Flux<Producto> Un flujo reactivo de productos.
     */
    public Flux<Producto> obtenerProductos() {
        return Flux.fromIterable(productos);
    }


}
