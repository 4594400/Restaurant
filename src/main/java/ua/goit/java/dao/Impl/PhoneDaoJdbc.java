package ua.goit.java.dao.Impl;

import ua.goit.java.dao.PhoneDao;
import ua.goit.java.model.Employee;
import ua.goit.java.model.Phone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class PhoneDaoJdbc implements PhoneDao {
    @Override
    public int insertPhonesByEmployeeId(Phone phone, Employee employee, Connection connection) {
        int result = -1;
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO phones(phone_number, employeeid) VALUES (?,?)")) {
            preparedStatement.setString(1, phone.getPhoneNumber());
            preparedStatement.setInt(2, employee.getEmpliyeeId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;


    }

    @Override
    public int insertPhonesByEmployeeId(List<Phone> phones, Employee employee, Connection connection) {
        return 0;

    }
}
