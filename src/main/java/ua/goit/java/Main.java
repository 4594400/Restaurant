package ua.goit.java;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.java.controller.*;
import ua.goit.java.model.*;
import ua.goit.java.service.DishService;
import ua.goit.java.service.MenuService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private DishService dishService;
    private MenuService menuService;
    private EmployeeController employeeController;
    private PhoneController phoneController;
    private DishController dishController;
    private MenuController menuController;
    private IngredientController ingredientController;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Main main = applicationContext.getBean(Main.class);


        main.start();
    }

    private void start() {

        //employeeController.printEmployeeByName("Ivan");
        //employeeController.printAllEmployee();
        //employeeController.printResultDeletingEmployeeById(19);
        //employeeController.printInsertedEmployee(createNewEmployee());

        //phoneController.printInsertedPhoneByEmployeeId("099-888-88-88", 10);
        //phoneController.printResultDeletedPhoneById(60);


        //dishController.printInsertedDish(createDish());
        //dishController.printResultDeletingDishById(24);
        //dishController.printDishByName("Пицца 4 сыра");
        //dishController.printAllDishes();
        //dishController.printDishesByMenuId(1);


        //menuController.printInsertedMenu(createMenu());
        //menuController.printMenuByName("Пьянка");
        //menuController.printInsertedDishIntoMenu(menuService.selectMenuByName("Пьянка").get(0), dishService.selectDishByName("Винегрет").get(0));
        //menuController.printDeletedDishFromMenu(menuService.selectMenuByName("Пьянка").get(0), dishService.selectDishByName("Винегрет").get(0));
        //menuController.printAllMenu();

        //ingredientController.printInsertedIngredient(new Ingredient("Сладкая картошка"));
        ingredientController.printResultDeletingIngredientById(37);
        //ingredientController.printIngredientsByName("Сладкая картошка");
        //ingredientController.printAllIngredients();

    }

    private Menu createMenu() {
        Menu menu = new Menu();
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Бифштекс", new DishCategory("Мясные блюда"), 120.50, 200, null));
        dishes.add(new Dish("Рыба под соусом", new DishCategory("Рыба"), 150, 130, null));

        menu.setMenuName("Пьянка2");
        menu.setDishList(dishes);

        return menu;
    }

    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setPhoneController(PhoneController phoneController) {
        this.phoneController = phoneController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void setIngredientController(IngredientController ingredientController) {
        this.ingredientController = ingredientController;
    }

    private Employee createNewEmployee(){
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone("050-213-15-36"));
        phones.add(new Phone("050-522-15-22"));
        phones.add(new Phone("098-775-15-77"));

        Role role = new Role("manager");

        return new Employee("Torn", "Samuel", Date.valueOf("2015-02-03"), phones, role, 2155.5);
    }

    private Dish createDish() {
        return new Dish("Бифштекс", new DishCategory("Мясные блюда"), 120.50, 200, null);
    }
}
