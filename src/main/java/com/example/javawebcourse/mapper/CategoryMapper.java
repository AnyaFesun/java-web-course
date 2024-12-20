package com.example.javawebcourse.mapper;

import com.example.javawebcourse.domain.Category;
import com.example.javawebcourse.dto.CategoryDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO toCategoryDTO(Category category);

    Category toCategory(CategoryDTO categoryDTO);
}