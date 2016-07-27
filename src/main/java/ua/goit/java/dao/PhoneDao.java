package ua.goit.java.dao;


import ua.goit.java.model.Employee;
import ua.goit.java.model.Phone;

import java.sql.Connection;
import java.util.List;

public interface PhoneDao {
    void save (Phone phone, Employee employee, Connection connection);
    void save (List<Phone> phones, Employee employee, Connection connection);
}
