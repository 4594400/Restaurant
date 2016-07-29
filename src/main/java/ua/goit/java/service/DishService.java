package ua.goit.java.service;


import ua.goit.java.dao.DishDao;
import ua.goit.java.model.Dish;

import java.util.List;

public class DishService {
    private DishDao dishDao;

    public int insertDish(Dish dish) {
        return dishDao.insertDish(dish);
    }

    public int deleteDishById(int id) {
        return dishDao.deleteDishById(id);
    }

    public List<Dish> selectDishByName(String name) {
        return dishDao.selectDishByName(name);
    }

    public List<Dish> selectAllDishes() {
        return dishDao.selectAllDishes();
    }





    public DishDao getDishDao() {
        return dishDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
