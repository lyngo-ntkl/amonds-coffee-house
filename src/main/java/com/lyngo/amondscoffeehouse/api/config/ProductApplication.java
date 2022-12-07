package com.lyngo.amondscoffeehouse.api.config;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

//@ApplicationPath("api")
public class ProductApplication extends ResourceConfig {
    public ProductApplication(){
        packages("com.lyngo.amondscoffeehouse.api.resource");
    }
}
