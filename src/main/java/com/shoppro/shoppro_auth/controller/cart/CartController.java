package com.shoppro.shoppro_auth.controller.cart;

import com.shoppro.shoppro_auth.dto.common.ApiResponse;
import com.shoppro.shoppro_auth.dto.request.cart.AddToCartRequest;
import com.shoppro.shoppro_auth.dto.response.cart.CartItemResponse;
import com.shoppro.shoppro_auth.entity.CartItem;
import com.shoppro.shoppro_auth.service.interfaces.CartService;
import com.shoppro.shoppro_auth.util.CurrentUser;
import com.shoppro.shoppro_auth.util.ResponseUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Order", description = "Order endpoints")
@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping
    public ResponseEntity<?> addToCart(@RequestBody AddToCartRequest request){
        cartService.addToCart(request);
        return ResponseUtil.success("Ürün Sepete Eklendi", request.getProductId());
    }

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<ApiResponse<String>> remove(@PathVariable Long cartItemId) {
        cartService.removeFromCart(cartItemId);
        return ResponseUtil.success("Ürün Sepetten Çıkarıldı", null);
    }

    @GetMapping
    public ResponseEntity<List<CartItemResponse>> getCart(){
        return ResponseUtil.list(cartService.getCart());
    }
}
