package ua.goit.java.service.Impl;


import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.dao.EmployeeDao;
import ua.goit.java.model.Employee;
import ua.goit.java.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public int insertEmployee(Employee employee) {
       return employeeDao.insertEmployee(employee);
    }

    @Override
    @Transactional
    public int deleteEmployeeById(int id) {
        return employeeDao.deleteEmployeeById(id);
    }

    @Override
    @Transactional
    public List<Employee> selectEmployeeByName(String name) {
        return employeeDao.selectEmployeeByName(name);
    }

    @Override
    @Transactional
    public List<Employee> selectAllEmployee() {
        return employeeDao.selectAllEmployee();
    }





    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
