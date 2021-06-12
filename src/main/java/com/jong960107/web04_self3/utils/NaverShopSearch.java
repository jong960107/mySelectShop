package com.jong960107.web04_self3.utils;


import com.jong960107.web04_self3.models.ItemDto;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class NaverShopSearch {


    public String search(String query) {


        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "hDdvv7U6jpS2fg0NcP5D");
        headers.add("X-Naver-Client-Secret", "kbodZoUJI5");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query="+ query, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);

        return response;

    }

    public List<ItemDto> fromJSONtoItems(String ret) {

        JSONObject rjson = new JSONObject(ret);
        JSONArray items = rjson.getJSONArray("items");
        List<ItemDto> itemDtoList = new ArrayList<>();
        for (int i = 0; i < items.length(); i++) {

            JSONObject itemJson = (JSONObject) items.getJSONObject(i);
            ItemDto itemDto = new ItemDto(itemJson);
            itemDtoList.add(itemDto);
        }

        return itemDtoList;
    }

    public static void main(String[] args) {

        NaverShopSearch naverShopSearch = new NaverShopSearch();
        String ret =  naverShopSearch.search("아이맥");
        naverShopSearch.fromJSONtoItems(ret);

        }

    }




