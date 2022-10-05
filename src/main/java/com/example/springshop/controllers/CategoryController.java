package com.example.springshop.controllers;


import com.example.springshop.dto.CategoryDTO;
import com.example.springshop.dto.ProductDTO;
import com.example.springshop.service.CategoryService;
import com.example.springshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final ProductService productService;

    private final CategoryService categoryService;

    public CategoryController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public String list(Model model, @PathVariable Long id) {
        List<ProductDTO> list = productService.getAll();
        List<CategoryDTO> list_cat = categoryService.getAll();
        model.addAttribute("products", list);
        model.addAttribute("categories", list_cat);
        return "category";
    }
}
