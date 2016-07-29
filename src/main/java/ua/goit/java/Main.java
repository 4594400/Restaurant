package ua.goit.java;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.java.controller.DishController;
import ua.goit.java.controller.EmployeeController;
import ua.goit.java.controller.PhoneController;
import ua.goit.java.model.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private EmployeeController employeeController;
    private PhoneController phoneController;
    private DishController dishController;

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
        dishController.printAllDishes();

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

    private Employee createNewEmployee(){
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone("050-213-15-36"));
        phones.add(new Phone("050-522-15-22"));
        phones.add(new Phone("098-775-15-77"));

        Role role = new Role("manager");

        return new Employee("Torn", "Samuel", Date.valueOf("2015-02-03"), phones, role, 2155.5);
    }

    private Dish createDish() {
        return new Dish("Бифштекс", new DishCategory("Мясные блюда"), 120.50, 200);
    }
}
