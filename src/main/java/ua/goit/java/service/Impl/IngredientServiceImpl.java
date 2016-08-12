package ua.goit.java.service.Impl;


import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.dao.IngredientDao;
import ua.goit.java.model.Ingredient;
import ua.goit.java.service.IngredientService;

import java.util.List;

public class IngredientServiceImpl implements IngredientService{
    private IngredientDao ingredientDao;

    @Override
    @Transactional
    public int insertIngredient(Ingredient ingredient) {
        return ingredientDao.insertIngredient(ingredient);
    }

    @Override
    @Transactional
    public int deleteIngredientById(int ingredientID) {
        return ingredientDao.deleteIngredientById(ingredientID);
    }

    @Override
    @Transactional
    public List<Ingredient> selectIngredientByName(String name) {
        return ingredientDao.selectIngredientByName(name);
    }

    @Override
    @Transactional
    public List<Ingredient> selectAllIngredients() {
        return ingredientDao.selectAllIngredients();
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
}
