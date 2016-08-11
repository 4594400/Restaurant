package ua.goit.java.controller;


import ua.goit.java.model.Dish;
import ua.goit.java.service.DishService;
import ua.goit.java.service.Impl.DishServiceImpl;

public class DishController {
    private DishService dishService;

    public void printInsertedDish(Dish dish) {
        System.out.println(dishService.insertDish(dish) + " dish was inserted");
        System.out.println(dish.toString());
    }

    public void printResultDeletingDishById(int id) {
        System.out.println("-------------------- printResultDeletingDishById --------------------------------------------------------------------------------------------------");
        System.out.println(dishService.deleteDishById(id) + " dish was deleted");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void printDishByName(String name) {
        System.out.println("-------------------- printDishByName with name: " + name + " --------------------------------------------------------------------------------------");
        dishService.selectDishByName(name).forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void printAllDishes() {
        System.out.println("-------------------- printAllDishes ---------------------------------------------------------------------------------------------------------------");
        dishService.selectAllDishes().forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void printDishesByMenuId(int menuId) {
        System.out.println("-------------------- printDishesByMenuId ---------------------------------------------------------------------------------------------------------------");
        dishService.selectDishesByMenuId(menuId).forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    }






    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }
}
