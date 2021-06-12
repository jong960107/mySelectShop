package com.jong960107.web04_self3.controller;


import com.jong960107.web04_self3.domain.Product;
import com.jong960107.web04_self3.domain.ProductRepository;
import com.jong960107.web04_self3.models.ProductMypriceRequestDto;
import com.jong960107.web04_self3.models.ProductRequestDto;
import com.jong960107.web04_self3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductService productService;
    private final ProductRepository productRepository;

    @GetMapping("/api/products")
    public List<Product> getProducts(){

        return productRepository.findAll();

    }


    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto productRequestDto){

        Product product = new Product(productRequestDto);
        productRepository.save(product);

        return product;
    }


    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) {
        return productService.update(id, requestDto);
    }

}
