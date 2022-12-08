package com.lyngo.amondscoffeehouse.dao;

import com.lyngo.amondscoffeehouse.dto.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AccountDAOTest {

    @ParameterizedTest
    @MethodSource("getAccount")
    public void testGetAccounts(String email, String password, Account account){
        Assertions.assertEquals(account, new AccountDAO().getAccount(email, password));
    }

    private static Stream<Arguments> getAccount(){
        return Stream.of(
                Arguments.of("admin@gmail.com", "1", new Account("Admin1","admin@gmail.com","1","Administrator","AD","012345678",true))
        );
    }
}
