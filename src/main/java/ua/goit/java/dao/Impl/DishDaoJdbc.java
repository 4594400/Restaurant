package ua.goit.java.dao.Impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.goit.java.dao.DishDao;
import ua.goit.java.dao.MenuDao;
import ua.goit.java.model.Dish;
import ua.goit.java.model.DishCategory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishDaoJdbc implements DishDao{

    public static final Logger LOGGER = LoggerFactory.getLogger(DishDaoJdbc.class);
    private DataSource dataSource;
    private DishCategoryDaoJdbc dishCategoryDaoJdbc = new DishCategoryDaoJdbc();
    private MenuDao menuDaoJdbc;

    //------------------------------ INSERT -------------------------------------------------------------------------------------
    @Override
    public int insertDish(Dish dish) {
        int result;
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO dishes (dish_name, dishcategoryid, price, weight) VALUES (?,?,?,?)")) {
            preparedStatement.setString(1,dish.getDishName());
            preparedStatement.setInt(2, dishCategoryDaoJdbc.selectDishCategoryIdByDishCategoryName(dish.getDishCategory().getDishcategoryName(), connection));
            preparedStatement.setDouble(3, dish.getPrice());
            preparedStatement.setDouble(4, dish.getWeight());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while inserting dish ", e);
            throw new RuntimeException(e);
        }
        return result;
    }
    //------------------------------DELETE BY ID----------------------------------------------------------------------------------
    @Override
    public int deleteDishById(int id) {
        int result;
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM dishes WHERE dishid = ?")) {
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while deleting Dish by dish Id ", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    //------------------------------SELECT BY NAME----------------------------------------------------------------------------------
    @Override
    public List<Dish> selectDishByName(String name) {
        List<Dish> dishes = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM dishes NATURAL JOIN dishcategories WHERE dish_name = ?")) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Dish dish = createDish(resultSet);
                dishes.add(dish);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while selecting dish by dish name ", e);
            throw new RuntimeException(e);
        }
        return dishes;
    }

    private Dish createDish(ResultSet resultSet) throws SQLException {
        Dish dish = new Dish();
        dish.setDishId(resultSet.getInt("dishid"));
        dish.setDishName(resultSet.getString("dish_name"));
        DishCategory dishCategory = new DishCategory();
        dishCategory.setDishcategoryId(resultSet.getInt("dishcategoryid"));
        dishCategory.setDishcategoryName(resultSet.getString("dishcategory_name"));
        dish.setDishCategory(dishCategory);
        dish.setPrice(resultSet.getDouble("price"));
        dish.setWeight(resultSet.getDouble("weight"));
        return dish;
    }
    //------------------------------------- SELECT ALL DISHES ---------------------------------------------------------------
    @Override
    public List<Dish> selectAllDishes() {
        List<Dish> dishes = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM dishes NATURAL JOIN dishcategories");
            while (resultSet.next()) {
                dishes.add(createDish(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while selecting all dishes ", e);
            throw new RuntimeException(e);
        }
        return dishes;
    }
    //------------------------------------- SELECT DISHES BY MENU ID ---------------------------------------------------------------

    @Override
    public List<Dish> selectDishesByMenuId(int menuID) {
        List<Dish> dishes = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
                PreparedStatement psDishes = connection.prepareStatement
                ("SELECT * FROM menu_dishes NATURAL JOIN menu NATURAL JOIN dishes WHERE menuid = ?")) {
            psDishes.setInt(1, menuID);
            ResultSet resultSet = psDishes.executeQuery();
            while (resultSet.next()) {
                Dish dish = createDish(connection, resultSet);
                dishes.add(dish);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while selecting DISHES BY MENU ID ", e);
            throw new RuntimeException(e);
        }
        return dishes;
    }

    @Override
    public List<Dish> selectDishesByMenuId(int menuID, Connection connection) {
        List<Dish> dishes = new ArrayList<>();
        try(PreparedStatement psDishes = connection.prepareStatement
                ("SELECT * FROM menu_dishes NATURAL JOIN menu NATURAL JOIN dishes WHERE menuid = ?")) {
            psDishes.setInt(1, menuID);
            ResultSet resultSet = psDishes.executeQuery();
            while (resultSet.next()) {
                Dish dish = createDish(connection, resultSet);
                dishes.add(dish);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while selecting DISHES BY MENU ID ", e);
            throw new RuntimeException(e);
        }
        return dishes;
    }

    //------------------------------------- CREATE DISH ---------------------------------------------------------------
    private Dish createDish(Connection connection, ResultSet resultSet) throws SQLException {
        Dish dish = new Dish();
        dish.setDishId(resultSet.getInt("dishID"));
        dish.setDishName(resultSet.getString("dish_name"));

        dish.setDishCategory(createDishCategory(connection, resultSet));

        dish.setPrice(resultSet.getDouble("price"));
        dish.setWeight(resultSet.getDouble("weight"));

        //dish.setMenuList(menuDaoJdbc.selectMenuByDishId(resultSet.getInt("dishID"), connection));
        return dish;
    }


    //------------------------------------- CREATE DISH CATEGORY ---------------------------------------------------------------
    private DishCategory createDishCategory(Connection connection, ResultSet resultSet) throws SQLException {
        DishCategory dishCategory = new DishCategory();
        dishCategory.setDishcategoryId(resultSet.getInt("dishcategoryID"));
        dishCategory.setDishcategoryName(dishCategoryDaoJdbc.selectDishCategoryNameByDishCategoryId(resultSet.getInt("dishcategoryID"), connection));
        return dishCategory;

    }







//------------------------------------- SETTERS --------------------------------------------------------------------------------

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setMenuDaoJdbc(MenuDao menuDaoJdbc) {
        this.menuDaoJdbc = menuDaoJdbc;
    }
}
