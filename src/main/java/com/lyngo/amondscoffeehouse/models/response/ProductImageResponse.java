package com.lyngo.amondscoffeehouse.models.response;

import com.lyngo.amondscoffeehouse.models.entity.Product;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductImageResponse {
    private int id;
    private String productImageLink;
    private Product product;
}
