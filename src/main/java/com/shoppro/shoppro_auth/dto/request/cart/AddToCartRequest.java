package com.shoppro.shoppro_auth.dto.request.cart;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddToCartRequest {
    private Long productId;
    private  int quantity;
}
