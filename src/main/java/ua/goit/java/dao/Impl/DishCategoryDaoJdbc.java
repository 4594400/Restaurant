package ua.goit.java.dao.Impl;

import jdk.nashorn.internal.ir.WhileNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.goit.java.dao.DishCategoryDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DishCategoryDaoJdbc implements DishCategoryDao {
    private DataSource dataSource;
    private static final Logger LOGGER = LoggerFactory.getLogger(DishCategoryDaoJdbc.class);

    @Override
    public int selectDishCategoryIdByDishCategoryName(String dishCategoryName) {
        int result = -1;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("SELECT dishcategoryid FROM dishcategories WHERE dishcategory_name = ?")) {
            preparedStatement.setString(1, dishCategoryName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getInt("dishcategoryid");
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while selectingDish category by dishCategoryId ", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int selectDishCategoryIdByDishCategoryName(String dishCategoryName, Connection connection) {
        int result = -1;
        try(PreparedStatement preparedStatement = connection.prepareStatement
                ("SELECT dishcategoryid FROM dishcategories WHERE dishcategory_name = ?")) {
            preparedStatement.setString(1, dishCategoryName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getInt("dishcategoryid");
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while selectingDish category by dishCategoryId ", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public String selectDishCategoryNameByDishCategoryId(int dishcategoryID) {
        String result="";
        try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT dishcategory_name FROM dishcategories WHERE dishcategoryid = ?")) {
        preparedStatement.setInt(1, dishcategoryID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getString("dishcategory_name");
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while selecting DishCategoryName By DishCategoryId ", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public String selectDishCategoryNameByDishCategoryId(int dishcategoryID, Connection connection) {
        String result="";
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT dishcategory_name FROM dishcategories WHERE dishcategoryid = ?")) {
            preparedStatement.setInt(1, dishcategoryID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getString("dishcategory_name");
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while selecting DishCategoryName By DishCategoryId ", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
