package com.technicaltest.shoppingcart.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailDto {
    private int orderDetailId;
    private String productId;
    private int quantity;
    private double price;
}
