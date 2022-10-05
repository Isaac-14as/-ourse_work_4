package com.example.springshop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class OrderDetails {

    private static final  String SEQ_NAME = "order_details_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private BigDecimal amount;
    private BigDecimal price;


//    public OrderDetails(Order order, Product product, Long amount) {
//        this.order = order;
//        this.product = product;
//        this.amount = new BigDecimal(amount);
//        this.price = product.getPrice();
//    }


    public OrderDetails(Product product, Long amount) {
        this.product = product;
        this.amount = new BigDecimal(amount);
        this.price = new BigDecimal(String.valueOf(product.getPrice()));
//        this.price = new BigDecimal(10);
//        this.id = new Long(1);
    }

}
