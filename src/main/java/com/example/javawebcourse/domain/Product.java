package com.example.javawebcourse.domain;

import lombok.*;

import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class Product {
    UUID id;
    String name;
    String description;
    float price;
    String origin;
    Category category;
}