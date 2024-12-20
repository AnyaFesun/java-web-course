package com.example.javawebcourse.dto;

import java.util.List;
import java.util.UUID;

import com.example.javawebcourse.domain.Product;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Value;


@Value
@Builder
public class OrderDTO {
    UUID id;

    @Positive(message = "Total price must be greater than 0.")
    float price;

    @NotBlank(message = "Customer name is required and cannot be blank.")
    @Size(min = 2, max = 100, message = "Customer name must be between 2 and 100 characters.")
    String customerName;

    List<ProductDTO> products;
}