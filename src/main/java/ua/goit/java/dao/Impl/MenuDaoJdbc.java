package ua.goit.java.dao.Impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.goit.java.dao.DishDao;
import ua.goit.java.dao.MenuDao;
import ua.goit.java.model.Dish;
import ua.goit.java.model.Menu;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDaoJdbc implements MenuDao{

    public static final Logger LOGGER = LoggerFactory.getLogger(DishDaoJdbc.class);
    private DataSource dataSource;
    private DishDao dishDaoJdbc;

    //------------------------------ INSERT -------------------------------------------------------------------------------------
    @Override
    public int insertMenu(Menu menu) {
        int result;
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO menu (menu_name) VALUES (?)")) {
            preparedStatement.setString(1,menu.getMenuName());
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while inserting menu ", e);
            throw new RuntimeException(e);
        }
        return result;
    }
    //------------------------------DELETE BY ID---------------------------------------------------------------------------------
    @Override
    public int deleteMenuById(int menuId) {
        int result;
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM menu WHERE menuid = ?")) {
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while deleting menu by ID ", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    //------------------------------SELECT BY NAME-------------------------------------------------------------------------------
    @Override
    public List<Menu> selectMenuByName(String name) {
        List<Menu> menus = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM menu WHERE menu_name = ?")) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Menu menu = new Menu();
                menu.setMenuId(resultSet.getInt("menuID"));
                menu.setMenuName(resultSet.getString("menu_name"));
                menu.setDishList(dishDaoJdbc.selectDishesByMenuId(resultSet.getInt("menuID"), connection));
                menus.add(menu);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while selecting menu by name ", e);
            throw new RuntimeException(e);
        }
        return menus;
    }

    //------------------------------------- SELECT ALL MENU ---------------------------------------------------------------------
    @Override
    public List<Menu> selectAllMenu() {
        return null;
    }

    //------------------------------------- SELECT ALL DISHES -------------------------------------------------------------------
    @Override
    public int insertDishToMenu(Dish dish) {
        return 0;
    }

    //------------------------------------- SELECT ALL DISHES -------------------------------------------------------------------
    @Override
    public int deleteDishFromMenuById(int dishId) {
        return 0;
    }


//------------------------------------- SELECT MENU BY DISHES ID ---------------------------------------------------------------

    @Override
    public List<Menu> selectMenuByDishId(int dishID, Connection connection) {
        List<Menu> menus = new ArrayList<>();
        try(PreparedStatement psMenu = connection.prepareStatement("SELECT * FROM menu_dishes NATURAL JOIN menu NATURAL JOIN dishes WHERE dishid = ?")) {
            psMenu.setInt(1, dishID);
            ResultSet resultSet = psMenu.executeQuery();
            while (resultSet.next()) {
                Menu menu = new Menu();
                menu.setMenuId(resultSet.getInt("menuID"));
                menu.setMenuName(resultSet.getString("menu_name"));
                menu.setDishList(dishDaoJdbc.selectDishesByMenuId(resultSet.getInt("menuID"), connection));
                menus.add(menu);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while selecting menu by dish Id ", e);
            throw new RuntimeException(e);
        }
        return menus;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setDishDaoJdbc(DishDao dishDaoJdbc) {
        this.dishDaoJdbc = dishDaoJdbc;
    }
}
