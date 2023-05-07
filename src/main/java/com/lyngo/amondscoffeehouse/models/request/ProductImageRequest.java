package com.lyngo.amondscoffeehouse.models.request;

import com.lyngo.amondscoffeehouse.models.entity.Product;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductImageRequest {
    private int id;
    private String productImageLink;
    private Product product;
}
