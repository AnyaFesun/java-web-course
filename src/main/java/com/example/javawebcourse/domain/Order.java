package com.example.javawebcourse.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Value
@Builder(toBuilder = true)
public class Order {
    UUID id;
    float price;
    String customerName;
    List<Product> products;
}