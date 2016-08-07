package ua.goit.java.service.Impl;


import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.dao.DishDao;
import ua.goit.java.model.Dish;
import ua.goit.java.service.DishService;

import java.util.List;

public class DishServiceImpl implements ua.goit.java.service.DishService {
    private DishDao dishDao;

    @Override
    @Transactional
    public int insertDish(Dish dish) {
        return dishDao.insertDish(dish);
    }

    @Override
    @Transactional
    public int deleteDishById(int id) {
        return dishDao.deleteDishById(id);
    }

    @Override
    @Transactional
    public List<Dish> selectDishByName(String name) {
        return dishDao.selectDishByName(name);
    }

    @Override
    @Transactional
    public List<Dish> selectAllDishes() {
        return dishDao.selectAllDishes();
    }






    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
