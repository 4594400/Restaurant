package ua.goit.java.controller;

import ua.goit.java.model.Dish;
import ua.goit.java.model.Menu;
import ua.goit.java.service.MenuService;

import java.util.List;

public class MenuController {
    private MenuService menuService;

    public void printInsertedMenu(Menu menu) {
        System.out.println(menuService.insertMenu(menu) + " menu was inserted");
        System.out.println(menu.toString());
    }

    public void printResultDeletingMenuById(int id) {
        System.out.println("-------------------- printResultDeletingMenuById --------------------------------------------------------------------------------------------------");
        System.out.println(menuService.deleteMenuById(id) + " menu was deleted");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void printMenuByName(String name) {
        System.out.println("-------------------- printMenuByName with name: " + name + " --------------------------------------------------------------------------------------");
        System.out.println(menuService.selectMenuByName(name));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    }


    public void printAllMenu() {
        System.out.println("-------------------- printAllMenus ---------------------------------------------------------------------------------------------------------------");
        menuService.selectAllMenu().forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void printInsertedDishIntoMenu(Menu menu, Dish dish) {
        System.out.println(menuService.insertDishToMenu(menu, dish) + " dish was inserted into menu");
        System.out.println(dish.getDishName() + " -> " + menu.getMenuName() + " was inserted");
    }

    public void printDeletedDishFromMenu(Menu menu, Dish dish) {
        System.out.println(menuService.deleteDishFromMenu(menu, dish) + " dish was deleted from menu");
        System.out.println(dish.getDishName() + " -> " + menu.getMenuName() + " was deleted");
    }


    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }
}
