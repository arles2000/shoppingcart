package com.technicaltest.shoppingcart.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {
    private String paymentId;
    private String orderId;
    private double amount;
    private String paymentMethod;  // e.g., Credit Card, PayPal
    private String status;  // e.g., Pending, Completed, Failed
}
