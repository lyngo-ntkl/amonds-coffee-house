package com.lyngo.amondscoffeehouse.dao;

import com.lyngo.amondscoffeehouse.dto.Account;

import java.util.List;

public interface IAccountDAO {
    boolean insertAccount(Account account);
    boolean updateAccount(Account account);
    boolean deleteAccount(Account account);
    Account getAccount(String accountId);
    List<Account> getAccounts();
}
