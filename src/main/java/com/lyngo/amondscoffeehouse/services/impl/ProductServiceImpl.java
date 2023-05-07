package com.lyngo.amondscoffeehouse.services.impl;

import com.lyngo.amondscoffeehouse.repositories.ProductRepository;
import com.lyngo.amondscoffeehouse.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
}
