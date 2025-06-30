package com.shoppro.shoppro_auth.service.impl;

import com.shoppro.shoppro_auth.dto.request.cart.AddToCartRequest;
import com.shoppro.shoppro_auth.dto.response.cart.CartItemResponse;
import com.shoppro.shoppro_auth.entity.CartItem;
import com.shoppro.shoppro_auth.entity.Product;
import com.shoppro.shoppro_auth.exception.ProductNotFoundException;
import com.shoppro.shoppro_auth.repository.CartItemRepository;
import com.shoppro.shoppro_auth.repository.ProductRepository;
import com.shoppro.shoppro_auth.service.interfaces.CartService;
import com.shoppro.shoppro_auth.util.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final CurrentUser currentUser;


    @Override
    public void addToCart(AddToCartRequest request){
        CartItem cartItem = cartItemRepository.findByUserIdAndProductId(currentUser.getId(), request.getProductId())
                .orElse(CartItem.builder().productId(request.getProductId()).quantity(0).userId(currentUser.getId()).build());
        cartItem.setQuantity(cartItem.getQuantity() + request.getQuantity());
        cartItemRepository.save(cartItem);
    }

    public void removeFromCart(Long cardItemId){
        cartItemRepository.deleteById(cardItemId);
    }

    public List<CartItemResponse> getCart(){
        Long userId = currentUser.getId();
        List<CartItem> items = cartItemRepository.findByUserId(userId);

        return items.stream().map(item -> {
            Product product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new ProductNotFoundException("Ürün bulunamadı: " + item.getProductId()));

            return new CartItemResponse(
                    item.getId(),
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    item.getQuantity()
            );
        }).toList();
    }
}
