package com.lyngo.amondscoffeehouse.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SessionFactoryUtilsTest {
    @Test
    public void testDatabaseConnectionReturnRight(){
        Assertions.assertNotNull(SessionFactoryUtils.getSessionFactory());
    }
}
