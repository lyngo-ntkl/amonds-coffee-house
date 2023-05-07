package com.lyngo.amondscoffeehouse.models.request;

import com.lyngo.amondscoffeehouse.common.enums.AccountRole;
import com.lyngo.amondscoffeehouse.models.entity.Contact;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class AccountRequest {
    private String id;
    private String email;
    private String password;
    private String username;
    private AccountRole role;
    private boolean blockedStatus;
    private List<Contact> contacts;
}
