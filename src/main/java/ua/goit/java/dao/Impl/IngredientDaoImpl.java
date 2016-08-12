package ua.goit.java.dao.Impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.goit.java.dao.IngredientDao;
import ua.goit.java.model.Ingredient;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredientDaoImpl implements IngredientDao{
    private static final Logger LOGGER = LoggerFactory.getLogger(IngredientDaoImpl.class);
    private DataSource dataSource;

    //------------------------------------- INSERT INGREDIENT  ---------------------------------------------------------------
    @Override
    public int insertIngredient(Ingredient ingredient) {
        String sql = "INSERT INTO ingredients (ingredient_name) VALUES (?)";
        int result;
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, ingredient.getIngredientName());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while inserting ingredient ", e);
            throw new RuntimeException(e);
        }
        return result;
    }
    //------------------------------------- DELETE INGREDIENT BY ID ---------------------------------------------------------------
    @Override
    public int deleteIngredientById(int ingredientID) {
        String sql = "DELETE FROM ingredients WHERE ingredientid = ?";
        int result;
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, ingredientID);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while deleting ingredient ", e);
            throw new RuntimeException(e);
        }
        return result;
    }
//------------------------------------- SELECT INGREDIENT BY NAME ---------------------------------------------------------------

    @Override
    public List<Ingredient> selectIngredientByName(String name) {
        List<Ingredient> ingredients = new ArrayList<>();

        String sql = "SELECT * FROM ingredients WHERE ingredient_name = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Ingredient ingredient = createIngredient(resultSet);
                ingredients.add(ingredient);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while selecting ingredient by name", e);
            throw new RuntimeException(e);
        }
        return ingredients;
    }
    //------------------------------------- SELECT ALL INGREDIENT ---------------------------------------------------------------
    @Override
    public List<Ingredient> selectAllIngredients() {
            List<Ingredient> ingredients = new ArrayList<>();

            String sql = "SELECT * FROM ingredients";
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Ingredient ingredient = createIngredient(resultSet);
                    ingredients.add(ingredient);
                }
            } catch (SQLException e) {
                LOGGER.error("Exception occurred while selecting all ingredient", e);
                throw new RuntimeException(e);
            }
            return ingredients;
    }

    //------------------------------------- CREATE INGREDIENT FROM RESULT SET---------------------------------------------------------------
    private Ingredient createIngredient(ResultSet resultSet) throws SQLException {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientID(resultSet.getInt("ingredientid"));
        ingredient.setIngredientName(resultSet.getString("ingredient_name"));
        return ingredient;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
