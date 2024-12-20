package com.example.javawebcourse.dto;

import com.example.javawebcourse.validation.ValidCosmicProduct;
import com.example.javawebcourse.validation.ExtendedValidation;
import jakarta.validation.constraints.*;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProductDTO {
    UUID id;

    @NotBlank(message = "Product name is required and cannot be blank.")
    @Size(min = 2, max = 100, message = "Product name must be between 2 and 100 characters.")
    @ValidCosmicProduct(groups = ExtendedValidation.class)
    String name;

    @Size(max = 500, message = "Description cannot exceed 500 characters, including spaces.")
    String description;

    @Positive(message = "Price must be greater than 0.")
    float price;

    @NotBlank(message = "Origin planet is required and cannot be blank.")
    @Size(min = 2, max = 50, message = "Origin planet name must be between 2 and 50 characters.")
    String origin;

    String categoryName;
}