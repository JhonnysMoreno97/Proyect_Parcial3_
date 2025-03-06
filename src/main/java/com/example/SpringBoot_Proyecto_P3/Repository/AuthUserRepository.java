package com.example.SpringBoot_Proyecto_P3.Repository;

import com.example.SpringBoot_Proyecto_P3.models.AuthUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interfaz que define las operaciones de repositorio para la entidad AuthUser.
 * Extiende de MongoRepository, lo que permite realizar operaciones CRUD en MongoDB.
        */

@Repository
public interface AuthUserRepository extends MongoRepository<AuthUser, String>{

   /**
    * Método para encontrar un usuario por su nombre de usuario.
    *
    * @return Un objeto Optional que contiene el usuario si se encuentra, o vacío si no existe.
    */

   Optional<AuthUser> findByUsername(String username);




}
