package com.shoppro.shoppro_auth.dto.request.payment;

import com.shoppro.shoppro_auth.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {
    private PaymentType paymentType;
}
