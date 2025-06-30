package com.shoppro.shoppro_auth.service.impl;

import com.shoppro.shoppro_auth.dto.request.payment.PaymentRequest;
import com.shoppro.shoppro_auth.entity.*;
import com.shoppro.shoppro_auth.exception.ProductNotFoundException;
import com.shoppro.shoppro_auth.repository.CartItemRepository;
import com.shoppro.shoppro_auth.repository.OrderItemRepository;
import com.shoppro.shoppro_auth.repository.OrderRepository;
import com.shoppro.shoppro_auth.repository.ProductRepository;
import com.shoppro.shoppro_auth.service.interfaces.OrderService;
import com.shoppro.shoppro_auth.service.interfaces.PaymentStrategy;
import com.shoppro.shoppro_auth.service.payment.PaymentStrategyFactory;
import com.shoppro.shoppro_auth.util.CurrentUser;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final CurrentUser currentUser;
    private final CartItemRepository cartRepo;
    private final ProductRepository productRepo;
    private final OrderRepository orderRepo;
    private final OrderItemRepository orderItemRepo;
    private final PaymentStrategyFactory paymentFactory;

    @Transactional
    public void payment(PaymentRequest request) {
        Long userId = currentUser.getId();
        User user = currentUser.get();
        List<CartItem> cartItems = cartRepo.findByUserId(userId);
        if (cartItems.isEmpty()) {
            throw new RuntimeException("Sepet boş!");
        }
        double total = 0.0;
        Order order = new Order();
        order.setUser(user);
        order.setPaymentType(request.getPaymentType());
        Order savedOrder = orderRepo.save(order);
        for (CartItem item : cartItems) {
            Product product = productRepo.findById(item.getProductId())
                    .orElseThrow(() -> new ProductNotFoundException("Ürün yok: " + item.getProductId()));
            double itemTotalPrice = product.getPrice() * item.getQuantity();
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(savedOrder);
            orderItem.setProduct(product);
            orderItem.setQuantity(item.getQuantity());
            orderItem.setUnitPrice(product.getPrice());
            orderItem.setTotalPrice(itemTotalPrice);

            orderItemRepo.save(orderItem);
            total += itemTotalPrice;
        }
        savedOrder.setTotalAmount(total);
        orderRepo.save(savedOrder);
        // ödeme işlemi
        PaymentStrategy strategy = paymentFactory.getStrategy(request.getPaymentType());
        strategy.pay(total);

        cartRepo.deleteByUserId(userId);
    }
}
