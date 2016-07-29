package ua.goit.java.controller;


import ua.goit.java.model.Dish;
import ua.goit.java.service.DishService;

public class DishController {
    private DishService dishService;

    public void printInsertedDish(Dish dish) {
        System.out.println(dishService.insertDish(dish) + " dish was inserted");
        System.out.println(dish.toString());
    }


    public DishService getDishService() {
        return dishService;
    }

    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }
}
