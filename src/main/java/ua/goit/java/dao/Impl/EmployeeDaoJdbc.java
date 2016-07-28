package ua.goit.java.dao.Impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.goit.java.dao.EmployeeDao;
import ua.goit.java.model.Employee;
import ua.goit.java.model.Phone;
import ua.goit.java.model.Role;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoJdbc implements EmployeeDao {
    public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDaoJdbc.class);

    private DataSource dataSource;
    //private PhoneDaoJdbc phoneDaoJdbc = new PhoneDaoJdbc();
    private RoleDaoJdbc roleDaoJdbc = new RoleDaoJdbc();

    @Override
    public int insertEmployee(Employee employee) {
        int result;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement psEmployees = connection.prepareStatement
                     ("INSERT INTO employees (surname, name,  birthday, roleid, salary) VALUES (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
             PreparedStatement psPhones = connection.prepareStatement
                     ("INSERT INTO phones (phone_number, employeeid) VALUES (?, ?)")) {

            psEmployees.setString(1, employee.getSurname());
            psEmployees.setString(2, employee.getName());
            psEmployees.setDate(3, employee.getBirthDay());
            psEmployees.setInt(4, roleDaoJdbc.selectRoleIdByTypeOfRole(employee.getRole().getTypeOfRole(), connection));
            psEmployees.setDouble(5, employee.getSalary());
            result = psEmployees.executeUpdate();

            ResultSet generatedKeysResultSet = psEmployees.getGeneratedKeys();
            generatedKeysResultSet.next();
            int generatedId = generatedKeysResultSet.getInt(1);

            for (int i = 0; i < employee.getPhone().size(); i++) {
                psPhones.setString(1, employee.getPhone().get(i).getPhoneNumber());
                psPhones.setLong(2, generatedId);
                psPhones.addBatch();
            }
            psPhones.executeBatch();


        } catch (SQLException e) {
            LOGGER.error("Exception occurred while saving employee ", e);
            throw new RuntimeException(e);
        }
        return result;
    }





//---------------------------------DELETE--------------------------------------------------------------------------------------
    @Override
    public int deleteEmployeeById(int id) {
        try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employees WHERE employeeid = ?")) {
            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while deleting by id", e);
            throw new RuntimeException(e);
        }
    }
//------------------------------SELECT BY NAME----------------------------------------------------------------------------------
    @Override
    public List<Employee> selectEmployeeByName(String name) {
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
            LOGGER.error("Exception occurred while selecting by name ", e);
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

        employee.setPhone(selectPhoneByEmployeeId(resultSet.getInt("employeeid"), connection));

        Role role = new Role();
        role.setRoleID(resultSet.getInt("roleid"));
        role.setTypeOfRole(resultSet.getString("type_of_role"));
        employee.setRole(role);
        employee.setSalary(resultSet.getDouble("salary"));
        return employee;
    }

    public List<Phone> selectPhoneByEmployeeId(int id, Connection connection) {
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
            LOGGER.error("Exception occurred while selecting phones by employee id ", e);
            throw new RuntimeException(e);
        }
        return phones;
    }

//------------------------------------- SELECT ALL EMPLOYEE ---------------------------------------------------------------
        @Override
    public List<Employee> selectAllEmployee() {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees NATURAL JOIN roles");
            while (resultSet.next()) {
                employees.add(createEmployee(connection,resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while selecting all employee ", e);
            throw new RuntimeException(e);
        }
        return employees;
    }



//----------------------------  GETTER AND SETTER ---------------------------------------------------------------------------

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
