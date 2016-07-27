package ua.goit.java.dao;


import ua.goit.java.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void save(Employee employee);
    int delete(int id);
    List<Employee> getByName(String name);
    List<Employee> getAll();

}
