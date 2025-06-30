package com.shoppro.shoppro_auth.service.interfaces;

import com.shoppro.shoppro_auth.dto.request.cart.AddToCartRequest;
import com.shoppro.shoppro_auth.dto.response.cart.CartItemResponse;

import java.util.List;

public interface CartService {
    void addToCart(AddToCartRequest request);
    void removeFromCart(Long cardItemId);
    List<CartItemResponse> getCart();
}
