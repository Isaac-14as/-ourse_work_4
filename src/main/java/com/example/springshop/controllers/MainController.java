package com.example.springshop.controllers;


import com.example.springshop.dto.CategoryDTO;
import com.example.springshop.dto.ProductDTO;
import com.example.springshop.service.CategoryService;
import com.example.springshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.rmi.MarshalledObject;
import java.util.List;

@Controller
public class MainController {

    private final CategoryService categoryService;

    public MainController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping({"", "/"})
    public String index(Model model) {
        List<CategoryDTO> list = categoryService.getAll();
        model.addAttribute("categories", list);
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
