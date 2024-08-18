package com.technicaltest.shoppingcart.controller;

import com.technicaltest.shoppingcart.utils.ApiResponse;
import com.technicaltest.shoppingcart.utils.ApiResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final RestTemplate restTemplate;

    public ProductController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/products")
    public Object getProducts() {
        try {
            // Define the external API URL
            String url = "https://fakestoreapi.com/products";
            // Fetch the products from the external API
            Object products = restTemplate.getForObject(url, Object.class);
            // Return the fetched products
            ApiResponse<Object> response = ApiResponseUtil.createSuccessResponse(products, "Products fetched successfully.");
            return ResponseEntity.ok(response);
        } catch (HttpClientErrorException e) {
            // Handle HTTP errors (e.g., 404, 500)
            ApiResponse<Object> response = ApiResponseUtil.createErrorResponse(e.getStatusCode().toString(), "Error fetching products: " + e.getMessage());
            return ResponseEntity.status(e.getStatusCode()).body(response);
        } catch (Exception e) {
            // Handle general errors
            ApiResponse<Object> response = ApiResponseUtil.createErrorResponse("500", "An unexpected error occurred: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}
