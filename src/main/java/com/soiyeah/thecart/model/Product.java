package com.soiyeah.thecart.model;

import com.soiyeah.thecart.model.dto.ProductDto;
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
    private String productCode;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private BigDecimal discountedPrice;
    private int availableQty;

    // Constructor without ID
    public Product(String productCode ,String name, String description, String category, BigDecimal price, BigDecimal discountedPrice, int availableQty) {
        this.productCode = productCode;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.discountedPrice = discountedPrice;
        this.availableQty = availableQty;
    }

    // DTO transformer
    public static Product from(ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setProductCode(productDto.getProductCode());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setCategory(productDto.getCategory());
        product.setPrice(productDto.getPrice());
        product.setDiscountedPrice(productDto.getDiscountedPrice());
        product.setAvailableQty(productDto.getAvailableQty());
        return product;
    }

}
