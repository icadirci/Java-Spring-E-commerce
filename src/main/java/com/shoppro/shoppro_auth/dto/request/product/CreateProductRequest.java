package com.shoppro.shoppro_auth.dto.request.product;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequest {
    @NotBlank(message = "Ürün adı boş olamaz")
    private String name;
    private String description;
    @NotBlank(message = "Fiyat boş olamaz")
    private Double price;
    @NotBlank(message = "Stadı boş olamaz")
    private int stock;
}