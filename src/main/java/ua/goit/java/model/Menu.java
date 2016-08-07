package ua.goit.java.model;


import java.util.List;

public class Menu {
    private int menuId;
    private String menuName;
    private List<Dish> dishList;

    public Menu() {
    }

    public Menu(String menuName, List<Dish> dishList) {
        this.menuName = menuName;
        this.dishList = dishList;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", dishList=" + dishList +
                '}';
    }
}
