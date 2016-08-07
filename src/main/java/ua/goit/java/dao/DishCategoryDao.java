package ua.goit.java.dao;


import ua.goit.java.model.DishCategory;

import java.sql.Connection;

public interface DishCategoryDao {
    int selectDishCategoryIdByDishCategoryName(String dishCategoryName);
    int selectDishCategoryIdByDishCategoryName(String dishCategoryName, Connection connection);

    String selectDishCategoryNameByDishCategoryId(int dishcategoryID);
    String selectDishCategoryNameByDishCategoryId(int dishcategoryID, Connection connection);
}
