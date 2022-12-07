package com.lyngo.amondscoffeehouse.dao;

import com.lyngo.amondscoffeehouse.dto.Product;
import com.lyngo.amondscoffeehouse.utils.SessionFactoryUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDAO implements IProductDAO{

    private SessionFactory sessionFactory;
    public ProductDAO(){
        sessionFactory = SessionFactoryUtils.getSessionFactory();
    }
    @Override
    public boolean insertProduct(Product product) {
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public boolean deleteProduct(Product product) {
        return false;
    }

    @Override
    public Product getProduct(int productId) {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = null;
        try(Session session = sessionFactory.openSession()){
            Query<Product> query = session.createQuery("from Product", Product.class);
            products = query.list();
        } catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }
}
