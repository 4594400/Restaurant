package ua.goit.java.dao;

import ua.goit.java.model.Dish;
import ua.goit.java.model.Menu;

import java.sql.Connection;
import java.util.List;

public interface MenuDao {
    int insertMenu(Menu menu);
    int deleteMenuById(int menuId);
    List<Menu> selectMenuByName(String name);
    List<Menu> selectAllMenu();
    int insertDishToMenu(Menu menu, Dish dish);
    int deleteDishFromMenu(Menu menu, Dish dish);

    List<Menu> selectMenuByDishId(int dishID, Connection connection);
}
