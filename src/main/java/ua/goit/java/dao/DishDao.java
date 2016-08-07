package ua.goit.java.dao;

import ua.goit.java.model.Dish;

import java.sql.Connection;
import java.util.List;

public interface DishDao {
    int insertDish(Dish dish);
    int deleteDishById(int id);
    List<Dish> selectDishByName(String name);
    List<Dish> selectAllDishes();

    List<Dish> selectDishesByMenuId(int menuID, Connection connection);
}
