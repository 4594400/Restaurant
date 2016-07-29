package ua.goit.java.dao.Impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.goit.java.dao.DishDao;
import ua.goit.java.model.Dish;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DishDaoJdbc implements DishDao{
    public static final Logger LOGGER = LoggerFactory.getLogger(DishDaoJdbc.class);
    private DataSource dataSource;
    private DishCategoryDaoJdbc dishCategoryDaoJdbc = new DishCategoryDaoJdbc();

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
            LOGGER.error("Exception occurred while selectingDish category by dishCategoryId ", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int deleteDishById(int id) {
        return 0;
    }

    @Override
    public List<Dish> selectByName(String name) {
        return null;
    }

    @Override
    public List<Dish> selectAllDishes() {
        return null;
    }








    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
