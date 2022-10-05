package com.example.springshop.mapper;

import com.example.springshop.domain.Category;
import com.example.springshop.domain.Product;
import com.example.springshop.dto.CategoryDTO;
import com.example.springshop.dto.ProductDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper MAPPER = Mappers.getMapper(CategoryMapper.class);
    Category toCategory(CategoryDTO dto);
    @InheritInverseConfiguration
    CategoryDTO fromCategory(Category category);
    List<Category> toCategoryList(List<CategoryDTO> categoryDTOS);
    List<CategoryDTO> fromCategoryList(List<Category> categories);
}
