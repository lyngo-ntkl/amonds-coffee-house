package com.lyngo.amondscoffeehouse.controllers;

import com.lyngo.amondscoffeehouse.services.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/product-images")
public class ProductImageController {
    @Autowired
    private ProductImageService productImageService;
}
