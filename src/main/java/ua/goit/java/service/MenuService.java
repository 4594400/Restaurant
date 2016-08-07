package ua.goit.java.service;


import ua.goit.java.model.Dish;
import ua.goit.java.model.Menu;

import java.util.List;

public interface MenuService {
    int insertMenu(Menu menu);
    int deleteMenuById(int menuId);
    List<Menu> selectMenuByName(String name);
    List<Menu> selectAllMenu();
    int insertDishToMenu(Dish dish);
    int deleteDishFromMenuById(int dishId);
}
