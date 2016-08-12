package ua.goit.java.dao;


import ua.goit.java.model.Ingredient;

import java.util.List;

public interface WarehouseDao {
    int editQuantityIngredients(int ingredientID, int quantity);
    List<Ingredient> selectQuantityLessThen(int quantity);

}
