package com.lyngo.amondscoffeehouse.utils;

import com.lyngo.amondscoffeehouse.dto.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
//import com.sun.el

public class SessionFactoryUtils {
    // apply Singleton pattern
    private static SessionFactory sessionFactory = null;
    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            Configuration con = new Configuration().configure()
                    .addAnnotatedClass(Account.class)
                    .addAnnotatedClass(Category.class)
                    .addAnnotatedClass(Contact.class)
                    .addAnnotatedClass(Order.class)
                    .addAnnotatedClass(OrderDetail.class)
                    .addAnnotatedClass(Product.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
            sessionFactory = con.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}
