package ua.goit.java.service.Impl;


import ua.goit.java.dao.WarehouseDao;
import ua.goit.java.model.Ingredient;

import java.util.List;

public class WarehouseServiswImpl implements WarehouseDao{
    private WarehouseDao warehouseDao;
    @Override
    public int editQuantityIngredients(int ingredientID, int quantity) {
        return warehouseDao.editQuantityIngredients(ingredientID, quantity);
    }

    @Override
    public List<Ingredient> selectQuantityLessThen(int quantity) {
        return warehouseDao.selectQuantityLessThen(quantity);
    }




    public void setWarehouseDao(WarehouseDao warehouseDao) {
        this.warehouseDao = warehouseDao;
    }
}
