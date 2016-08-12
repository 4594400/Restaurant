package ua.goit.java.dao.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.goit.java.dao.WarehouseDao;
import ua.goit.java.model.Ingredient;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class WarehouseDaoImpl implements WarehouseDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(WarehouseDaoImpl.class);
    private DataSource dataSource;

    @Override
    public int editQuantityIngredients(int ingredientID, int quantity) {
        String sql = "UPDATE warehouse SET quantity = ? WHERE ingredientid = ?";
        int result;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, ingredientID);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while editing quantity ingredients on warehouse ", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public List<Ingredient> selectQuantityLessThen(int quantity) {
        List<Ingredient> ingredients = new ArrayList<>();
        String sql = "SELECT * FROM warehouse NATURAL JOIN ingredients WHERE quantity < ?";
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, quantity);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Ingredient ingredient = new Ingredient();
                ingredient.setIngredientID(resultSet.getInt("ingredientID"));
                ingredient.setIngredientName(resultSet.getString("ingredient_name"));
                ingredients.add(ingredient);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while selecting quantity ingredients less then ", e);
            throw new RuntimeException(e);
        }

        return ingredients;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
