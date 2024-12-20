package com.example.javawebcourse.dto;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CategoryDTO {
    UUID id;

    @NotBlank(message = "Category name is required and cannot be blank.")
    @Size(min = 2, max = 50, message = "Category name must be between 2 and 50 characters.")
    String name;
}