package ua.goit.java.service;


import ua.goit.java.model.Ingredient;

import java.util.List;

public interface WarehouseService {
    int editQuantityIngredients(int ingredientID, int quantity);
    List<Ingredient> selectQuantityLessThen(int quantity);
}
