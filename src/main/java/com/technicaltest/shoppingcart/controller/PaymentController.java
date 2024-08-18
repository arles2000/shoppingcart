package com.technicaltest.shoppingcart.controller;

import com.technicaltest.shoppingcart.model.Payment;
import com.technicaltest.shoppingcart.utils.ApiResponse;
import com.technicaltest.shoppingcart.utils.ApiResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @PostMapping
    public ResponseEntity<ApiResponse<Payment>> processPayment(@RequestBody Payment payment) {
        // Payment process simulation
        payment.setPaymentId(UUID.randomUUID().toString());
        payment.setStatus("Completed");  // Here we simulate that the payment was completed successfully

        ApiResponse<Payment> response = ApiResponseUtil.createSuccessResponse(payment, "Payment processed successfully.");
        return ResponseEntity.ok(response);
    }

}
