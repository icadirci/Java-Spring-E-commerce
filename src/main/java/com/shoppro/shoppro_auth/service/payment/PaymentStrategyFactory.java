package com.shoppro.shoppro_auth.service.payment;

import com.shoppro.shoppro_auth.enums.PaymentType;
import com.shoppro.shoppro_auth.service.interfaces.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStrategyFactory {
    private final CreditCardPaymentStrategy creditCard;
    private final CashPaymentStrategy cash;
    private final WalletPaymentStrategy wallet;

    public PaymentStrategy getStrategy(PaymentType type) {
        return switch (type) {
            case CREDIT_CARD -> creditCard;
            case CASH -> cash;
            case WALLET -> wallet;
        };
    }
}
