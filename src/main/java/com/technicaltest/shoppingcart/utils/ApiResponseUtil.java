package com.technicaltest.shoppingcart.utils;

import java.util.Collections;
import java.util.List;

public class ApiResponseUtil {

    public static <T> ApiResponse<T> createSuccessResponse(T data, String message) {
        return new ApiResponse<>(true, "200", data, Collections.singletonList(message));
    }

    public static <T> ApiResponse<T> createErrorResponse(String statusCode, String message) {
        return new ApiResponse<>(false, statusCode, null, Collections.singletonList(message));
    }

    public static <T> ApiResponse<T> createErrorResponse(String statusCode, List<String> messages) {
        return new ApiResponse<>(false, statusCode, null, messages);
    }
}
