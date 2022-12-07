package com.lyngo.amondscoffeehouse.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
//import com.sun.el

public class SessionFactoryUtils {
    // apply Singleton pattern
    private static SessionFactory sessionFactory = null;
    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            Configuration con = new Configuration().configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
            sessionFactory = con.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}
