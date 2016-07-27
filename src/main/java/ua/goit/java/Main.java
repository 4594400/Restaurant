package ua.goit.java;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.java.model.Employee;
import ua.goit.java.model.Phone;
import ua.goit.java.service.EmployeeService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    private EmployeeService employeeService;
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();
    }

    private void start() {
        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(new Phone("050-213-15-36"));
        phoneList.add(new Phone("098-258-25-52"));
        //Employee employee = new Employee("Smith", "John", new Date(), phoneList,  "manager", 2111.33);
        //employeeService.addEmployee(employee);

        //employeeService.remove(6);
        System.out.println("----------------------------------------");
        employeeService.getEmployeeByName("Bob").forEach(System.out::println);
        System.out.println("----------------------------------------");
        //employeeService.getAllEmployee().forEach(System.out::println);

    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
