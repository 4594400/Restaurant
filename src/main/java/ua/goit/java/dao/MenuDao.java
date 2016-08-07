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
    int insertDishToMenu(Dish dish);
    int deleteDishFromMenuById(int dishId);

    List<Menu> selectMenuByDishId(int dishID, Connection connection);
}
