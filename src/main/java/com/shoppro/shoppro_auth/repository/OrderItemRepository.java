package com.shoppro.shoppro_auth.repository;

import com.shoppro.shoppro_auth.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
