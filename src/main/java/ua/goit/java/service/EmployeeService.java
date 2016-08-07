package ua.goit.java.service;

import ua.goit.java.model.Employee;

import java.util.List;


public interface EmployeeService {

    int insertEmployee(Employee employee);


    int deleteEmployeeById(int id);


    List<Employee> selectEmployeeByName(String name);


    List<Employee> selectAllEmployee();




}
