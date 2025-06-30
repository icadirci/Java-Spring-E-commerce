package com.shoppro.shoppro_auth.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "card_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // şimdilik login olmadığı için statik 1 kullanacağız

    private Long productId;

    private int quantity;
}
