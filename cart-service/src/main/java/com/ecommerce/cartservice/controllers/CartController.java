package com.ecommerce.cartservice.controllers;

import com.ecommerce.models.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {

    @GetMapping("/getAllProducts")
    List<Product> getCartAllProduct() {
        return getAllProduct();
    }

    @Autowired
    RestTemplate restTemplate;

    public List<Product> getAllProduct() {
        final String ROOT_URI = "http://product-service/product/getAll";
        /**
         * we can use http://product-service/product/getAll we shout put RestTemplate annotation with LoadBalanced
         * if product service is down then full entire service is down.
         * we want to prevent that we using circuit break pattern.
         */

        ResponseEntity<Product[]> response = restTemplate.getForEntity(ROOT_URI, Product[].class);
        return Arrays.asList(response.getBody());
    }
}
