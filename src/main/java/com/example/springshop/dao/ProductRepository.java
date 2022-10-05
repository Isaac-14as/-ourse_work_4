package com.example.springshop.dao;

import com.example.springshop.domain.Product;
import com.example.springshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
