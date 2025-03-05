package com.example.SpringBoot_Proyecto_P3.Repository;

import com.example.SpringBoot_Proyecto_P3.models.AuthUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends MongoRepository<AuthUser, String>{
   Optional<AuthUser> findByUsername(String username);




}
