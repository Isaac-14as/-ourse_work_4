package com.example.springshop.controllers;


import com.example.springshop.dao.ProductRepository;
import com.example.springshop.domain.Bucket;
import com.example.springshop.domain.Product;
import com.example.springshop.dto.CategoryDTO;
import com.example.springshop.dto.ProductDTO;
import com.example.springshop.service.CategoryService;
import com.example.springshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
    }

    @GetMapping
    public String list(Model model) {
        List<ProductDTO> list = productService.getAll();
        model.addAttribute("products", list);
        return "products";
    }

    @GetMapping("/{id}/{category_1}/bucket")
    public String addBucket(@PathVariable Long id, Principal principal) {
        if (principal == null) {
            return "redirect:/category/{category_1}";
        }
        productService.addToUserBucket(id, principal.getName());
        return "redirect:/category/{category_1}";
    }

    @GetMapping("/{id}/{category_1}/buckettwo")
    public String addBucketTwo(@PathVariable Long id, Principal principal) {
        if (principal == null) {
            return "redirect:/products/product_page/{id}";
        }
        productService.addToUserBucket(id, principal.getName());
        return "redirect:/products/product_page/{id}";
    }


    @GetMapping("/{id}/remove/bucket")
    public String deleteBucket(@PathVariable Long id, Principal principal) {
        if (principal == null) {
            return "redirect:/bucket";
        }
        productService.deleteToUserBucket(id, principal.getName());
        return "redirect:/bucket";
    }

    @GetMapping("/product_page/{id}")
    public String productView(Model model, @PathVariable String id) {
        List<ProductDTO> list = productService.getAll();
        model.addAttribute("products", list);
        return "product";
    }
}
