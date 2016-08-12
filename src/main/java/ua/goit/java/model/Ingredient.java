package ua.goit.java.model;


public class Ingredient {
    private Integer ingredientID;
    private String ingredientName;

    public Ingredient() {
    }

    public Ingredient(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Integer getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(Integer ingredientID) {
        this.ingredientID = ingredientID;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientID=" + ingredientID +
                ", ingredientName='" + ingredientName + '\'' +
                '}';
    }
}
