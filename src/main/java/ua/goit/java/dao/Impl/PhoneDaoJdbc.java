package ua.goit.java.dao.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.goit.java.dao.PhoneDao;
import ua.goit.java.model.Employee;
import ua.goit.java.model.Phone;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class PhoneDaoJdbc implements PhoneDao {
    private DataSource dataSource;
    public static final Logger LOGGER = LoggerFactory.getLogger(RoleDaoJdbc.class);

    @Override
    public int insertPhoneByEmployeeId(String phoneNumber, int employeeId) {
        int result;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("INSERT INTO phones(phone_number, employeeid) VALUES (?,?)")) {
            preparedStatement.setString(1, phoneNumber);
            preparedStatement.setInt(2, employeeId);
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while inserting phone by employee id ", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int insertPhoneByEmployeeId(String phoneNumber, int employeeId, Connection connection) {
        int result;
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO phones(phone_number, employeeid) VALUES (?,?)")) {
            preparedStatement.setString(1, phoneNumber);
            preparedStatement.setInt(2, employeeId);

            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while inserting phone by employee id ", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    //---------------------------------DELETE--------------------------------------------------------------------------------------
    @Override
    public int deletePhoneById(int id) {
        int result;
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM phones WHERE phoneid = ?")) {
            preparedStatement.setInt(1, id);
            result =preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while deleting phone by id ", e);
            throw new RuntimeException(e);
        }
        return result;
    }











    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
