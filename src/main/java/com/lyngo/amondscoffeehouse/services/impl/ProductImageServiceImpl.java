package com.lyngo.amondscoffeehouse.services.impl;

import com.lyngo.amondscoffeehouse.repositories.ProductImageRepository;
import com.lyngo.amondscoffeehouse.services.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    @Autowired
    private ProductImageRepository productImageRepository;
}
