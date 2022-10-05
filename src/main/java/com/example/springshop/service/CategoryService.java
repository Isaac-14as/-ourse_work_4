package com.example.springshop.service;

import com.example.springshop.domain.Category;
import com.example.springshop.dto.CategoryDTO;
import com.example.springshop.dto.ProductDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAll();


}
