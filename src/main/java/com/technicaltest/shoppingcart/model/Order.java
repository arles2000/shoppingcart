package com.technicaltest.shoppingcart.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private String orderId;
    private String customerName;
    private String product;
    private int quantity;
    private double price;
}
