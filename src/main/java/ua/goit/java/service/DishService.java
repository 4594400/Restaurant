package ua.goit.java.service;

import ua.goit.java.model.Dish;

import java.util.List;


public interface DishService {

    int insertDish(Dish dish);


    int deleteDishById(int id);


    List<Dish> selectDishByName(String name);


    List<Dish> selectAllDishes();
}
