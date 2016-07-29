package ua.goit.java.service;


import ua.goit.java.dao.DishDao;
import ua.goit.java.model.Dish;

public class DishService {
    private DishDao dishDao;

    public int insertDish(Dish dish) {
        return dishDao.insertDish(dish);
    }





    public DishDao getDishDao() {
        return dishDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
