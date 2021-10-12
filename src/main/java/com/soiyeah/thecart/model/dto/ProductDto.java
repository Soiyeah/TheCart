package com.soiyeah.thecart.model.dto;

import com.soiyeah.thecart.model.Customer;
import com.soiyeah.thecart.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@Getter
@Setter
public class ProductDto {

    private long id;
    private String productCode;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private BigDecimal discountedPrice;
    private int availableQty;

    public static ProductDto from(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setProductCode(product.getProductCode());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setCategory(product.getCategory());
        productDto.setPrice(product.getPrice());
        productDto.setDiscountedPrice(product.getDiscountedPrice());
        productDto.setAvailableQty(product.getAvailableQty());
        return productDto;
    }

}
