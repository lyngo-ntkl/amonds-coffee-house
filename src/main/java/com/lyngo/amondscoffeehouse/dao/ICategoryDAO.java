package com.lyngo.amondscoffeehouse.dao;

import com.lyngo.amondscoffeehouse.dto.Category;

import java.util.List;

public interface ICategoryDAO {
    boolean insertCategory(Category category);
    boolean updateCategory(Category category);
    boolean deleteCategory(Category category);
    Category getCategory(int categoryId);
    List<Category> getCategories();
}
