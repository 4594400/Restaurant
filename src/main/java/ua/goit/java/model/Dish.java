package ua.goit.java.model;


import java.util.List;

public class Dish {
    private int dishId;
    private String dishName;
    private DishCategory dishCategory;
    private double price;
    private double weight;
    private List<Menu> menuList;

    public Dish() {
    }

    public Dish(String dishName, DishCategory dishCategory, double price, double weight, List<Menu> menuList) {
        this.dishName = dishName;
        this.dishCategory = dishCategory;
        this.price = price;
        this.weight = weight;
        this.menuList = menuList;
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

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishId=" + dishId +
                ", dishName='" + dishName + '\'' +
                ", dishCategory=" + dishCategory +
                ", price=" + price +
                ", weight=" + weight +
                ", menuList=" + menuList +
                '}';
    }
}
