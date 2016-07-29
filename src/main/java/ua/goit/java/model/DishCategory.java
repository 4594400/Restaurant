package ua.goit.java.model;

public class DishCategory {
    private int dishcategoryId;
    private String dishcategoryName;

    public DishCategory() {
    }

    public DishCategory(String dishcategoryName) {
        this.dishcategoryName = dishcategoryName;
    }

    public int getDishcategoryId() {
        return dishcategoryId;
    }

    public void setDishcategoryId(int dishcategoryId) {
        this.dishcategoryId = dishcategoryId;
    }

    public String getDishcategoryName() {
        return dishcategoryName;
    }

    public void setDishcategoryName(String dishcategoryName) {
        this.dishcategoryName = dishcategoryName;
    }

    @Override
    public String toString() {
        return "DishCategory{" +
                "dishcategoryId=" + dishcategoryId +
                ", dishcategoryName='" + dishcategoryName + '\'' +
                '}';
    }
}
