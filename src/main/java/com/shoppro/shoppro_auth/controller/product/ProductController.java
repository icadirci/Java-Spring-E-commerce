package com.shoppro.shoppro_auth.controller.product;

import com.shoppro.shoppro_auth.dto.common.ApiResponse;
import com.shoppro.shoppro_auth.dto.request.product.CreateProductRequest;
import com.shoppro.shoppro_auth.dto.request.product.UpdateProductRequest;
import com.shoppro.shoppro_auth.dto.response.product.ProductResponse;
import com.shoppro.shoppro_auth.service.interfaces.ProductService;
import com.shoppro.shoppro_auth.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
@Tag(name = "Product", description = "Product endpoints")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll() {
        return ResponseUtil.list(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponse>> getById(@PathVariable Long id) {
        return ResponseUtil.success("Ürün getirildi.", productService.findById(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<String>> update(
            @PathVariable Long id,
            @RequestBody UpdateProductRequest request
    ) {
        productService.update(id, request);
        return ResponseUtil.success("Ürün başarıyla güncellendi.", request.getName());
    }

    @Operation(
            summary = "Yeni ürün oluştur",
            description = "Gerekli bilgilerle yeni ürün kaydı oluşturur"
    )
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<ProductResponse>> create(@Valid @RequestBody CreateProductRequest request) {
        ProductResponse product = productService.create(request);
        return  ResponseUtil.success("Ürün başarıyla eklendi.", product);
    }
}
