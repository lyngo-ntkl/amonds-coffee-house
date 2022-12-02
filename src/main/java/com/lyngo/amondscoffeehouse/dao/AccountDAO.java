package com.lyngo.amondscoffeehouse.dao;

import com.lyngo.amondscoffeehouse.dto.Account;

import java.util.List;

public class AccountDAO implements IAccountDAO{
    @Override
    public boolean insertAccount(Account account) {
        return false;
    }

    @Override
    public boolean updateAccount(Account account) {
        return false;
    }

    @Override
    public boolean deleteAccount(Account account) {
        return false;
    }

    @Override
    public Account getAccount(String accountId) {
        return null;
    }

    @Override
    public List<Account> getAccounts() {
        return null;
    }
}
