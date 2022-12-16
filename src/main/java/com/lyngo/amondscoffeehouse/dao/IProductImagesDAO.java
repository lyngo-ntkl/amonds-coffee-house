package com.lyngo.amondscoffeehouse.dao;

import com.lyngo.amondscoffeehouse.dto.ProductImage;

import java.util.List;

public interface IProductImagesDAO {
    boolean insertProductImage(ProductImage productImage);
    boolean updateProductImage(ProductImage productImage);
    boolean deleteProductImage(ProductImage productImage);
    ProductImage getProductImage(int productImageId);
    List<ProductImage> getProductImages();
}
