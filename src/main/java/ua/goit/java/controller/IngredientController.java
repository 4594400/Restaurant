package ua.goit.java.controller;


import ua.goit.java.model.Ingredient;
import ua.goit.java.service.IngredientService;

public class IngredientController {
    private IngredientService ingredientService;

    public void printInsertedIngredient(Ingredient ingredient) {
        System.out.println("-------------------- printResultDeletingIngredientById --------------------------------------------------------------------------------------------------");

        System.out.println(ingredientService.insertIngredient(ingredient) + " ingredient with name = " + ingredient.getIngredientName() + " was inserted");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void printResultDeletingIngredientById(int id) {
        System.out.println("-------------------- printResultDeletingIngredientById --------------------------------------------------------------------------------------------------");
        System.out.println(ingredientService.deleteIngredientById(id) + " ingredient with id = " + id + " was deleted");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void printIngredientsByName(String name) {
        System.out.println("-------------------- printIngredientsByName ---------------------------------------------------------------------------------------------------------------");
        ingredientService.selectIngredientByName(name).forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void printAllIngredients() {
        System.out.println("-------------------- printIngredientsByName ---------------------------------------------------------------------------------------------------------------");
        ingredientService.selectAllIngredients().forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    }




    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
}
