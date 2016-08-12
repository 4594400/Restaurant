package ua.goit.java.model;


public class Warehouse {
    private Ingredient ingredientID;
    private Double quantity;
    private String measure;

    public Warehouse() {
    }

    public Warehouse(Ingredient ingredientID, Double quantity, String measure) {
        this.ingredientID = ingredientID;
        this.quantity = quantity;
        this.measure = measure;
    }

    public Ingredient getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(Ingredient ingredientID) {
        this.ingredientID = ingredientID;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "ingredientID=" + ingredientID +
                ", quantity=" + quantity +
                ", measure='" + measure + '\'' +
                '}';
    }
}
