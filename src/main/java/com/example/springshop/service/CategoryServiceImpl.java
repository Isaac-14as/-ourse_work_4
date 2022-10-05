package com.example.springshop.service;

import com.example.springshop.dao.CategoryRepository;
import com.example.springshop.dto.CategoryDTO;

import com.example.springshop.mapper.CategoryMapper;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper mapper = CategoryMapper.MAPPER;

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAll() {
        return mapper.fromCategoryList(categoryRepository.findAll());
    }
}
