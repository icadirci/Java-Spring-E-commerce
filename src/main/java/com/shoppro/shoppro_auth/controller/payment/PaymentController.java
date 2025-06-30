package com.shoppro.shoppro_auth.controller.payment;

import com.shoppro.shoppro_auth.dto.common.ApiResponse;
import com.shoppro.shoppro_auth.dto.request.payment.PaymentRequest;
import com.shoppro.shoppro_auth.service.interfaces.OrderService;
import com.shoppro.shoppro_auth.util.ResponseUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Payment", description = "Payment endpoints")
@RestController
@RequestMapping("api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> payment(@Valid  @RequestBody PaymentRequest request){
        orderService.payment(request);
        return ResponseUtil.success("Siparişiniz alındı! teşekkürler", null);
    }

}
