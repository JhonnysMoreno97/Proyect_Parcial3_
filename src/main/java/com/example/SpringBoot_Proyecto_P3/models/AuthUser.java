package com.example.SpringBoot_Proyecto_P3.models;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

/**
 * Clase que representa un usuario en la base de datos MongoDB.
 */

// Genera automáticamente métodos getter, setter, equals, hashCode y toString
@Data

// Proporciona un patrón de construcción (Builder) para crear objetos de esta clase
@Builder


// Especifica que esta clase se almacenará en la colección "user" en MongoDB
@Document("user")
//@Document(collection = "user")
public class AuthUser {
        @Id // Indica que este campo es la clave primaria en MongoDB
        private String id;

        @Indexed // Crea un índice en la base de datos para mejorar la búsqueda por este campo
        private String username;
        private String password;
        private boolean active; // Indica si el usuario está activo o no
}