package com.lyngo.amondscoffeehouse.models.response;

import com.lyngo.amondscoffeehouse.models.entity.Account;
import com.lyngo.amondscoffeehouse.models.entity.Invoice;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ContactResponse {
    private String id;
    private String phoneNumber;
    private String province;
    private String district;
    private String ward;
    private boolean defaultStatus;
    private Account account;
    private List<Invoice> invoices;
}
