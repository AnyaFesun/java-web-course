package com.example.javawebcourse.mapper;

import com.example.javawebcourse.domain.Order;

import com.example.javawebcourse.domain.Product;
import com.example.javawebcourse.dto.OrderDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "products", target = "products")
    OrderDTO toOrderDTO(Order order);

    @Mapping(source = "products", target = "products")
    Order toOrder(OrderDTO orderDTO);
}

