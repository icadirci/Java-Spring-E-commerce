package com.shoppro.shoppro_auth.service.interfaces;

import com.shoppro.shoppro_auth.dto.request.payment.PaymentRequest;
import org.springframework.stereotype.Service;

public interface OrderService {
    public void payment(PaymentRequest request);
}
