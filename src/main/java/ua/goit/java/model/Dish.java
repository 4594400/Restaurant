package ua.goit.java.model;


public class Dish {
    private int dishId;
    private String dishName;
    private DishCategory dishCategory;
    private double price;
    private double weight;

    public Dish() {
    }

    public Dish(String dishName, DishCategory dishCategory, double price, double weight) {
        this.dishName = dishName;
        this.dishCategory = dishCategory;
        this.price = price;
        this.weight = weight;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public DishCategory getDishCategory() {
        return dishCategory;
    }

    public void setDishCategory(DishCategory dishCategory) {
        this.dishCategory = dishCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishId=" + dishId +
                ", dishName='" + dishName + '\'' +
                ", dishCategory=" + dishCategory +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}
