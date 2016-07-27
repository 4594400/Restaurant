package ua.goit.java.service;


import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.dao.EmployeeDAO;
import ua.goit.java.dao.Impl.EmployeeDaoJdbc;
import ua.goit.java.model.Employee;

import java.util.List;

public class EmployeeService {
    private EmployeeDAO employeeDAO;

    @Transactional
    public void addEmployee(Employee employee) {
        employeeDAO.save(employee);
    }
    @Transactional
    public int remove (int id) {
        return employeeDAO.delete(id);
    }

    @Transactional
    public List<Employee> getEmployeeByName(String name) {
        return employeeDAO.getByName(name);
    }

    @Transactional
    public List<Employee> getAllEmployee() {
        return employeeDAO.getAll();
    }





    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
}
