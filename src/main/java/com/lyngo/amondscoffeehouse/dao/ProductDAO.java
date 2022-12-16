package com.lyngo.amondscoffeehouse.dao;

import com.lyngo.amondscoffeehouse.dto.Product;
import com.lyngo.amondscoffeehouse.utils.SessionFactoryUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDAO implements IProductDAO{

    private static SessionFactory sessionFactory;
    private static final String SEARCH_TYPE_NAME = "name";
    private static final String SEARCH_TYPE_CATEGORY = "category";
    public ProductDAO(){
        sessionFactory = SessionFactoryUtils.getSessionFactory();
    }
    @Override
    public boolean insertProduct(Product product) {
        boolean check = true;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            check = false;
            if(transaction != null){
                transaction.rollback();
            }
        }
        return check;
    }

    @Override
    public boolean updateProduct(Product product) {
        boolean check = true;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            check = false;
            if(transaction != null){
                transaction.rollback();
            }
        }
        return check;
    }

    @Override
    public boolean deleteProduct(Product product) {
        boolean check = true;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.remove(product);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            check = false;
            if(transaction != null){
                transaction.rollback();
            }
        }
        return check;
    }

    @Override
    public Product getProduct(int productId) {
        Product product;
        try (Session session = sessionFactory.openSession()){
            product = session.get(Product.class,productId);
        }
        return product;
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

    @Override
    public List<Product> searchProducts(String searchKey, String type){
        if(SEARCH_TYPE_NAME.equals(type)) {
            return searchProductsByName(searchKey);
        } else {
            return searchProductsByCategory(searchKey);
        }
    }

    private List<Product> searchProductsByName(String searchKey){
        List<Product> products = null;
        try (Session session = sessionFactory.openSession()){
            Query<Product> query = session.createQuery("from Product where productName like '%"+ searchKey +"%'", Product.class);
            products = query.list();
        } catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }

    private List<Product> searchProductsByCategory(String searchKey){
        List<Product> products = null;
        try (Session session = sessionFactory.openSession()){
            Query<Product> query = session.createQuery("from Product where category.categoryId=:key", Product.class);
            query.setParameter("key", searchKey);
            products = query.list();
        } catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }
}
