package com.shoppro.shoppro_auth.repository;

import com.shoppro.shoppro_auth.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
