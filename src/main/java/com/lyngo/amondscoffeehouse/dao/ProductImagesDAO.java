package com.lyngo.amondscoffeehouse.dao;

import com.lyngo.amondscoffeehouse.dto.ProductImage;
import com.lyngo.amondscoffeehouse.utils.SessionFactoryUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProductImagesDAO implements IProductImagesDAO {
    private final SessionFactory sessionFactory;
    public ProductImagesDAO(){
        sessionFactory = SessionFactoryUtils.getSessionFactory();
    }

    @Override
    public boolean insertProductImage(ProductImage productImage) {
        boolean check = true;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.persist(productImage);
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
    public boolean updateProductImage(ProductImage productImage) {
        return false;
    }

    @Override
    public boolean deleteProductImage(ProductImage productImage) {
        return false;
    }

    @Override
    public ProductImage getProductImage(int productImageId) {
        return null;
    }

    @Override
    public List<ProductImage> getProductImages() {
        return null;
    }
}
