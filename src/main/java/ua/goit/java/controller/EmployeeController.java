package ua.goit.java.controller;


import ua.goit.java.model.Employee;
import ua.goit.java.service.EmployeeService;
import ua.goit.java.service.Impl.EmployeeServiceImpl;

public class EmployeeController {
    private EmployeeService employeeService;

    public void printEmployeeByName(String name) {
        System.out.println("-------------------- printEmployeeByName with name: " +name+ " ----------------------------------------------------------------------------------------");
        employeeService.selectEmployeeByName(name).forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void printAllEmployee(){
        System.out.println("-------------------- printAllEmployee -----------------------------------------------------------------------------------------------------------------");
        employeeService.selectAllEmployee().forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void printResultDeletingEmployeeById(int id) {
        System.out.println("-------------------- printResultDeletingEmployeeById --------------------------------------------------------------------------------------------------");
        System.out.println(employeeService.deleteEmployeeById(id) + " employee with id = " + id + " was deleted");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void printInsertedEmployee(Employee employee) {

        System.out.println(employeeService.insertEmployee(employee) + " employee was inserted");
        System.out.println(employee.toString());
    }


    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setEmployeeService(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
}
