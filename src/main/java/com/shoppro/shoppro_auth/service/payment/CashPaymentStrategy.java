package com.shoppro.shoppro_auth.service.payment;

import com.shoppro.shoppro_auth.service.interfaces.PaymentStrategy;
import org.springframework.stereotype.Component;

@Component
public class CashPaymentStrategy implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Kapıda ödeme alındı: ₺" + amount);
    }
}
