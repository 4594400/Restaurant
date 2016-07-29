package ua.goit.java.dao;

import ua.goit.java.model.Dish;

import java.util.List;

public interface DishDao {
    int insertDish(Dish dish);
    int deleteDishById(int id);
    List<Dish> selectByName(String name);
    List<Dish> selectAllDishes();
}
