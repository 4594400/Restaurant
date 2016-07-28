package ua.goit.java.dao;


import ua.goit.java.model.Employee;
import ua.goit.java.model.Phone;

import java.sql.Connection;
import java.util.List;

public interface PhoneDao {
    int insertPhoneByEmployeeId(String phoneNumber, int employeeId);
    int insertPhoneByEmployeeId(String phoneNumber, int employeeId, Connection connection);


}
