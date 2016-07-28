package ua.goit.java;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.java.controller.EmployeeController;
import ua.goit.java.model.Employee;
import ua.goit.java.model.Phone;
import ua.goit.java.model.Role;
import ua.goit.java.service.EmployeeService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private EmployeeController employeeController;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Main main = applicationContext.getBean(Main.class);


        main.start();
    }

    private void start() {

        employeeController.printEmployeeByName("Ivan");
        employeeController.printAllEmployee();
        employeeController.printResultDeletingEmployeeById(19);
        employeeController.printResultDeletingEmployeeById(21);
        employeeController.printInsertedEmployee(createNewEmployee());

    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    private Employee createNewEmployee(){
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone("050-213-15-36"));
        phones.add(new Phone("050-522-15-22"));
        phones.add(new Phone("098-775-15-77"));

        Role role = new Role("manager");

        Employee employee = new Employee("Torn", "Samuel", Date.valueOf("2015-02-03"), phones, role, 2155.5);

        return employee;
    }
}
