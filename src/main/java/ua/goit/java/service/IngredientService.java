package ua.goit.java.service;


import ua.goit.java.model.Ingredient;

import java.util.List;

public interface IngredientService {
    int insertIngredient(Ingredient ingredient);
    int deleteIngredientById(int ingredientID);
    List<Ingredient> selectIngredientByName(String name);
    List<Ingredient> selectAllIngredients();
}
