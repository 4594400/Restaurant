package ua.goit.java.dao;


import ua.goit.java.model.Ingredient;

import java.util.List;

public interface IngredientDao {
    int insertIngredient(Ingredient ingredient);
    int deleteIngredientById(int ingredientID);
    List<Ingredient> selectIngredientByName(String name);
    List<Ingredient> selectAllIngredients();

}
