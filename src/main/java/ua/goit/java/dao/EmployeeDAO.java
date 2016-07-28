package ua.goit.java.dao;


import ua.goit.java.model.Employee;

import java.util.List;

public interface EmployeeDao {
    int insertEmployee(Employee employee);
    int deleteEmployeeById(int id);
    List<Employee> selectEmployeeByName(String name);
    List<Employee> selectAllEmployee();

}
