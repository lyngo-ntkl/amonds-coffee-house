package com.lyngo.amondscoffeehouse.models.request;

import com.lyngo.amondscoffeehouse.common.enums.PaymentMethods;
import com.lyngo.amondscoffeehouse.models.entity.Contact;
import com.lyngo.amondscoffeehouse.models.entity.InvoiceDetail;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Builder
@Data
public class InvoiceRequest {
    private String id;
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal discount;
    private BigDecimal total;
    private Timestamp createdDate;
    private PaymentMethods paymentMethod;
    private Contact contact;
    private List<InvoiceDetail> invoiceDetails;
}
