package com.soiyeah.thecart.service;

import com.soiyeah.thecart.model.Product;
import com.soiyeah.thecart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product getProduct(Long productId){
        return productRepository.findById(productId).orElseThrow();
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }



}
