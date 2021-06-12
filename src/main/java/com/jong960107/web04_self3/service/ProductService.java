package com.jong960107.web04_self3.service;


import com.jong960107.web04_self3.domain.Product;
import com.jong960107.web04_self3.domain.ProductRepository;
import com.jong960107.web04_self3.models.ProductMypriceRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Long update(Long id, ProductMypriceRequestDto productMypriceRequestDto){

        Product product = productRepository.findById(id).orElseThrow(

                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );

        product.update(productMypriceRequestDto);

        return id;

    }

}
