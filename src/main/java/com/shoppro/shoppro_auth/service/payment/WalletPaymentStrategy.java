package com.shoppro.shoppro_auth.service.payment;

import com.shoppro.shoppro_auth.service.interfaces.PaymentStrategy;
import org.springframework.stereotype.Component;

@Component
public class WalletPaymentStrategy implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Cüzdan ile ödeme yapıldı: ₺" + amount);
    }
}
