package ua.goit.java.dao.Impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.goit.java.dao.EmployeeDAO;
import ua.goit.java.model.Employee;
import ua.goit.java.model.Phone;
import ua.goit.java.model.Role;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoJdbc implements EmployeeDAO {
    public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDaoJdbc.class);

    private DataSource dataSource;
    private PhoneDaoJdbc phoneDaoJdbc;

    @Override
    public void save(Employee employee) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("INSERT INTO employees (surname, name,  birthday, roleid, salary) VALUES (?,?,?,?,?)")) {
            preparedStatement.setString(1, employee.getSurname());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setDate(3, employee.getBirthDay());
            //preparedStatement.setInt(2, employee.getRole());
            preparedStatement.executeUpdate();
            phoneDaoJdbc.save(employee.getPhone().get(0), employee, connection);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while saving employee ", e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public int delete(int id) {
        try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employees WHERE employeeid = ?")) {
            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();
            System.out.println(result + " employee with id: " + id + " was deleted");

            return result;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Employee> getByName(String name) {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("SELECT * FROM employees NATURAL JOIN roles WHERE name = ?")) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Employee employee = createEmployee(connection, resultSet);

                employees.add(employee);
            }

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException(e);
        }
        return employees;
    }

    private Employee createEmployee(Connection connection, ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setEmpliyeeId(resultSet.getInt("employeeid"));
        employee.setSurname(resultSet.getString("surname"));
        employee.setName(resultSet.getString("name"));
        employee.setBirthDay(resultSet.getDate("birthday"));

        employee.setPhone(getPhoneByEmployeeId(resultSet.getInt("employeeid"), connection));

        Role role = new Role();
        role.setRoleID(resultSet.getInt("roleid"));
        role.setTypeOfRole(resultSet.getString("type_of_role"));
        employee.setRole(role);
        employee.setSalary(resultSet.getDouble("salary"));
        return employee;
    }

    public List<Phone> getPhoneByEmployeeId(int id, Connection connection) {
        List<Phone> phones = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM phones NATURAL JOIN employees WHERE employeeid = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Phone phone = new Phone();
                phone.setPhoneId(resultSet.getInt("phoneid"));
                phone.setPhoneNumber(resultSet.getString("phone_number"));
                phones.add(phone);
            }

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while selecting phones ", e);
            throw new RuntimeException(e);
        }
        return phones;
    }


        @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees NATURAL JOIN roles");
            while (resultSet.next()) {
                employees.add(createEmployee(connection,resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException(e);
        }
        return employees;
    }





    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
