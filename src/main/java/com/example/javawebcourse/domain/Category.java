package com.example.javawebcourse.domain;

import lombok.*;

import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class Category {
    UUID id;
    String name;
}