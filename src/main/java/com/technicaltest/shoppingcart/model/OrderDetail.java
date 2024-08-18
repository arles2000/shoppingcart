package com.technicaltest.shoppingcart.model;

import  lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetail {
    private String orderDetailId;
    private String orderId;
    private String productId;
    private int quantity;
    private double price;
}
