package com.example.SpringBoot_Proyecto_P3.controller;


import com.example.SpringBoot_Proyecto_P3.models.Producto;
import com.example.SpringBoot_Proyecto_P3.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/api/productos") // Define la ruta base para los endpoints de productos
public class ProductoController {


    @Autowired
    private ProductoService productoService; // Inyección del servicio que maneja la lógica de productos

    /**
     * Endpoint para listar todos los productos.
     *
     * @return Un flujo reactivo (Flux) con la lista de productos.
     */

    @GetMapping
    public Flux<Producto> ListarProductos() {
        return productoService.obtenerProductos();

    }

}
