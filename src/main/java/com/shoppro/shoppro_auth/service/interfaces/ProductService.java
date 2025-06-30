package com.shoppro.shoppro_auth.service.interfaces;

import com.shoppro.shoppro_auth.dto.request.product.CreateProductRequest;
import com.shoppro.shoppro_auth.dto.request.product.UpdateProductRequest;
import com.shoppro.shoppro_auth.dto.response.product.ProductResponse;
import com.shoppro.shoppro_auth.entity.Product;

import java.util.List;

public interface ProductService {
    ProductResponse create(CreateProductRequest request);
    List<ProductResponse> findAll();
    ProductResponse findById(Long id);
    void update(Long id, UpdateProductRequest request);
}
