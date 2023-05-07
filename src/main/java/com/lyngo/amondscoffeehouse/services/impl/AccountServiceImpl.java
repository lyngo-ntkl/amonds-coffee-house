package com.lyngo.amondscoffeehouse.services.impl;

import com.lyngo.amondscoffeehouse.repositories.AccountRepository;
import com.lyngo.amondscoffeehouse.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
}
