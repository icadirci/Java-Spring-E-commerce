package com.shoppro.shoppro_auth.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String role; // Örn: "ROLE_USER", "ROLE_ADMIN"

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}
