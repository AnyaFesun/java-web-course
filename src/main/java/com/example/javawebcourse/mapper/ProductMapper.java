package com.example.javawebcourse.mapper;

import com.example.javawebcourse.domain.Product;
import com.example.javawebcourse.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "category.name", target = "categoryName")
    ProductDTO toProductDTO(Product product);

    @Mapping(source = "categoryName", target = "category.name")
    Product toProduct(ProductDTO productDTO);
}