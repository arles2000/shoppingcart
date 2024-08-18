package com.technicaltest.shoppingcart.utils;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {
    private boolean status;
    private String statusCode;
    private T data;
    private List<String> messages;

    public ApiResponse(boolean status, String statusCode, T data, List<String> messages) {
        this.status = status;
        this.statusCode = statusCode;
        this.data = data;
        this.messages = messages;
    }
}
