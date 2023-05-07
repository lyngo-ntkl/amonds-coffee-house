package com.lyngo.amondscoffeehouse.models.response;

import com.lyngo.amondscoffeehouse.common.enums.ProductCategories;
import com.lyngo.amondscoffeehouse.models.entity.InvoiceDetail;
import com.lyngo.amondscoffeehouse.models.entity.ProductImage;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ProductResponse {
    private int id;
    private String productName;
    private double price;
    private int quantity;
    private String description;
    private ProductCategories category;
    private List<InvoiceDetail> invoiceDetails;
    private List<ProductImage> productImages;
}
