package com.shoppro.shoppro_auth.service.payment;

import com.shoppro.shoppro_auth.service.interfaces.PaymentStrategy;
import org.springframework.stereotype.Component;

@Component
public class CreditCardPaymentStrategy implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Kredi kartıyla ödendi: ₺" + amount);
    }
}
