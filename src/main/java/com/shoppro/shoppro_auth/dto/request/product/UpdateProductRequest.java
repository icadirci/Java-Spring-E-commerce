package com.shoppro.shoppro_auth.dto.request.product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateProductRequest {
    private String name;
    private String description;
    private Double price;
    private int stock;
}
