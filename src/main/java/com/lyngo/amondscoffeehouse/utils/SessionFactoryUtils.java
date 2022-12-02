package com.lyngo.amondscoffeehouse.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtils {
    private static SessionFactory sessionFactory = null;
    public static SessionFactory getSessionFactory(){
//        if(sessionFactory == null){
            Configuration con = new Configuration().configure();
            SessionFactory sf = con.buildSessionFactory();
//        }
        return sessionFactory;
    }
}
