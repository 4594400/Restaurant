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
    public void save(Phone phone, Employee employee, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO phones(phone_number, employeeid) VALUES (?,?)")) {
            preparedStatement.setString(1, phone.getPhoneNumber());
            preparedStatement.setInt(2, employee.getEmpliyeeId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void save(List<Phone> phones, Employee employee, Connection connection) {

    }
}
