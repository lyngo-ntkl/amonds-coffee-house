package com.lyngo.amondscoffeehouse.dao;

import com.lyngo.amondscoffeehouse.dto.Category;
import com.lyngo.amondscoffeehouse.utils.SessionFactoryUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryDAO implements ICategoryDAO{
    private final SessionFactory sessionFactory;
    public CategoryDAO(){
        sessionFactory = SessionFactoryUtils.getSessionFactory();
    }
    @Override
    public boolean insertCategory(Category category) {
        return false;
    }

    @Override
    public boolean updateCategory(Category category) {
        return false;
    }

    @Override
    public boolean deleteCategory(Category category) {
        return false;
    }

    @Override
    public Category getCategory(int categoryId) {
        Category category = null;
        try (Session session = sessionFactory.openSession()){
            category = session.get(Category.class, categoryId);
        } catch (Exception e){
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public List<Category> getCategories() {
        List<Category> categories = null;
        try (Session session = sessionFactory.openSession()){
            Query<Category> query = session.createQuery("from Category", Category.class);
            categories = query.list();
        } catch (Exception e){
            e.printStackTrace();
        }
        return categories;
    }
}
