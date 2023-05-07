package com.lyngo.amondscoffeehouse.models.request;

import com.lyngo.amondscoffeehouse.models.entity.Account;
import com.lyngo.amondscoffeehouse.models.entity.Invoice;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ContactRequest {
    private String id;
    private String phoneNumber;
    private String province;
    private String district;
    private String ward;
    private boolean defaultStatus;
    private Account account;
    private List<Invoice> invoices;
}
