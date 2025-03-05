package com.example.SpringBoot_Proyecto_P3.models;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Builder
//@Document(collection = "user")
@Document("user")
public class AuthUser {
        @Id
        private String id;

        @Indexed
        private String username;
        private String password;
        private boolean active;
}