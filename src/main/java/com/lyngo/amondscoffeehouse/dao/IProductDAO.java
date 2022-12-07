package com.lyngo.amondscoffeehouse.dao;

import com.lyngo.amondscoffeehouse.dto.Product;

import java.util.List;

public interface IProductDAO {
    boolean insertProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(Product product);
    Product getProduct(int productId);
    List<Product> getProducts();
}
