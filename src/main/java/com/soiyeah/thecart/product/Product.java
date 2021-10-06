package com.soiyeah.thecart.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private BigDecimal discountedPrice;
    private int availableQty;

    // Constructor without ID
    public Product(String name, String description, String category, BigDecimal price, BigDecimal discountedPrice, int availableQty) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.discountedPrice = discountedPrice;
        this.availableQty = availableQty;
    }
}
