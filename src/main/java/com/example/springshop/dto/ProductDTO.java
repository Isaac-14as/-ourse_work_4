package com.example.springshop.dto;


import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String imgId;
    private String title;
    private BigDecimal price;
    private String description;
    private int category;
}
