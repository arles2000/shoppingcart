package com.technicaltest.shoppingcart.controller;

import com.technicaltest.shoppingcart.model.Order;
import com.technicaltest.shoppingcart.utils.ApiResponse;
import com.technicaltest.shoppingcart.utils.ApiResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @PostMapping
    public ResponseEntity<ApiResponse<Order>> createOrder(@RequestBody Order order) {
        try {

            ApiResponse<Order> response = ApiResponseUtil.createSuccessResponse(order, "Order created successfully.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ApiResponse<Order> response = ApiResponseUtil.createErrorResponse("500", "An error occurred while creating the order: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}
