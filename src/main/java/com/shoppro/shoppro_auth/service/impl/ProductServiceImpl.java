package com.shoppro.shoppro_auth.service.impl;

import com.shoppro.shoppro_auth.dto.request.product.CreateProductRequest;
import com.shoppro.shoppro_auth.dto.request.product.UpdateProductRequest;
import com.shoppro.shoppro_auth.dto.response.product.ProductResponse;
import com.shoppro.shoppro_auth.entity.Product;
import com.shoppro.shoppro_auth.exception.ProductNotFoundException;
import com.shoppro.shoppro_auth.repository.ProductRepository;
import com.shoppro.shoppro_auth.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    final private ProductRepository productRepository;

    @Override
    public ProductResponse create(CreateProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .stock(request.getStock())
                .build();
        Product saved = productRepository.save(product);

        return new ProductResponse(
                saved.getId(),
                saved.getName(),
                saved.getDescription(),
                saved.getPrice(),
                saved.getStock()
        );
    }

    @Override
    public List<ProductResponse> findAll(){
        return productRepository.findAll()
                .stream()
                .map(p -> new ProductResponse(
                        p.getId(),
                        p.getName(),
                        p.getDescription(),
                        p.getPrice(),
                        p.getStock()
                )).toList();
    }

    @Override
    public ProductResponse findById(Long id) {
        Product p = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        return new ProductResponse(p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getStock());
    }

    @Override
    public void update(Long id, UpdateProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Ürün bulunamadı"));

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());

        productRepository.save(product);
    }


}
