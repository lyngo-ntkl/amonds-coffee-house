package com.lyngo.amondscoffeehouse.models.response;

import com.lyngo.amondscoffeehouse.models.entity.Invoice;
import com.lyngo.amondscoffeehouse.models.entity.Product;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class InvoiceDetailResponse {
    private String id;
    private int quantity;
    private BigDecimal amount;
    private Invoice invoice;
    private Product product;
}
