package ua.goit.java.service;


import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.dao.EmployeeDao;
import ua.goit.java.model.Employee;

import java.util.List;

public class EmployeeService {
    private EmployeeDao employeeDao;

    @Transactional
    public int insertEmployee(Employee employee) {
       return employeeDao.insertEmployee(employee);
    }
    @Transactional
    public int deleteEmployeeById(int id) {
        return employeeDao.deleteEmployeeById(id);
    }

    @Transactional
    public List<Employee> selectEmployeeByName(String name) {
        return employeeDao.selectEmployeeByName(name);
    }

    @Transactional
    public List<Employee> selectAllEmployee() {
        return employeeDao.selectAllEmployee();
    }





    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
