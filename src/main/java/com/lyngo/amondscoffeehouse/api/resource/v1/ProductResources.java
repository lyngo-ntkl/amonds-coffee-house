package com.lyngo.amondscoffeehouse.api.resource.v1;

import com.lyngo.amondscoffeehouse.dao.ProductDAO;
import com.lyngo.amondscoffeehouse.dto.Product;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

//@Path("v1/products")
public class ProductResources {
//    @GET
    public List<Product> getProduct(){
        return new ProductDAO().getProducts();
    }
}
