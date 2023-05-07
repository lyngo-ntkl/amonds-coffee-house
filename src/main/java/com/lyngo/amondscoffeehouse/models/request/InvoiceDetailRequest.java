package com.lyngo.amondscoffeehouse.models.request;

import com.lyngo.amondscoffeehouse.models.entity.Invoice;
import com.lyngo.amondscoffeehouse.models.entity.Product;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class InvoiceDetailRequest {
    private String id;
    private int quantity;
    private BigDecimal amount;
    private Invoice invoice;
    private Product product;
}
