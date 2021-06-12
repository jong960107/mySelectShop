package com.jong960107.web04_self3.controller;


import com.jong960107.web04_self3.models.ItemDto;
import com.jong960107.web04_self3.utils.NaverShopSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchRequestController {

    private final NaverShopSearch naverShopSearch;

    @GetMapping("/api/search")
    public List<ItemDto> getItems(@RequestParam String query){

        String resultString = naverShopSearch.search(query);
        return naverShopSearch.fromJSONtoItems(resultString);

    }


}
