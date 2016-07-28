package ua.goit.java.dao;


import ua.goit.java.model.Employee;
import ua.goit.java.model.Phone;

import java.sql.Connection;
import java.util.List;

public interface PhoneDao {
    int insertPhonesByEmployeeId(Phone phone, Employee employee, Connection connection);
    int insertPhonesByEmployeeId(List<Phone> phones, Employee employee, Connection connection);
}
