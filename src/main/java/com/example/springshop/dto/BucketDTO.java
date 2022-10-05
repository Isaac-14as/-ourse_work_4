package com.example.springshop.dto;

import com.example.springshop.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BucketDTO {
    private int amountProducts;

//    private Long id;
    private Double sum;
    private List<BucketDetailDTO> bucketDetails = new ArrayList<>();
    public void aggregate() {
        this.amountProducts = bucketDetails.size();
        this.sum = bucketDetails.stream()
                .map(BucketDetailDTO::getSum)
                .mapToDouble(Double::doubleValue)
                .sum();
    }
//    public BucketDTO(Product product) {
//        this.title = product.getTitle();
//        this.productId = product.getId();
//        this.imgId = product.getImgId();
//        this.price = product.getPrice();
//        this.amount = new BigDecimal(1.0);
//        this.sum = Double.valueOf(product.getPrice().toString());
//    }
}
