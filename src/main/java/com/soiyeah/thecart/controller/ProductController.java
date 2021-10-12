package com.soiyeah.thecart.controller;


import com.soiyeah.thecart.model.Product;
import com.soiyeah.thecart.model.dto.ProductDto;
import com.soiyeah.thecart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path="api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value = {"id"})
    public ResponseEntity<Product> getProduct(@PathVariable final Long id){
        Product product = productService.getProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto){
        Product product = productService.addProduct(Product.from(productDto));
        return new ResponseEntity<>(ProductDto.from(product), HttpStatus.OK);
    }

}
