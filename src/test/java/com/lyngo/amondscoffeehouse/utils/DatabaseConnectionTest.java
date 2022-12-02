package com.lyngo.amondscoffeehouse.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest {
//    @Test
    public static void testDatabaseConnectionReturnRight(){
        Assertions.assertNotNull(SessionFactoryUtils.getSessionFactory());
    }
}
