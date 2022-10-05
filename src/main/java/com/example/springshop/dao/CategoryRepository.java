package com.example.springshop.dao;

import com.example.springshop.domain.Category;
import com.example.springshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
