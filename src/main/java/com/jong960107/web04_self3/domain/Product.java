package com.jong960107.web04_self3.domain;


import com.jong960107.web04_self3.models.ProductMypriceRequestDto;
import com.jong960107.web04_self3.models.ProductRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Product extends Timestamped{


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int lprice;

    @Column(nullable = false)
    private int myprice;

    public Product(ProductRequestDto productRequestDto){

        this.title = productRequestDto.getTitle();
        this.image = productRequestDto.getImage();
        this.link = productRequestDto.getLink();
        this.lprice = productRequestDto.getLprice();
        this.myprice = 0;


    }

    public void update(ProductMypriceRequestDto productMypriceRequestDto){

        this.myprice = productMypriceRequestDto.getMyprice();

    }



}
