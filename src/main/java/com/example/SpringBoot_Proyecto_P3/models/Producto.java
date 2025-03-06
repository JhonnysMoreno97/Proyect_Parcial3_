package com.example.SpringBoot_Proyecto_P3.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
@Document("productos")
public class Producto {

    @Id
    private String id;

    @Indexed
    private String nombre_producto;
    private double precio_producto;
}
