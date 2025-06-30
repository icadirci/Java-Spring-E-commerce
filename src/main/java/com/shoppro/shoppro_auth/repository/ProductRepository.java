package com.shoppro.shoppro_auth.repository;

import com.shoppro.shoppro_auth.entity.Product;
import com.shoppro.shoppro_auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
