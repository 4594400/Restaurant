package ua.goit.java.dao.Impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.goit.java.dao.RoleDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDaoJdbc implements RoleDao {

    private DataSource dataSource;
    public static final Logger LOGGER = LoggerFactory.getLogger(RoleDaoJdbc.class);

    @Override
    public int selectRoleIdByTypeOfRole(String typeOfRole) {
        int result = -1;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("SELECT roleid FROM roles WHERE type_of_role = ?")) {
            preparedStatement.setString(1, typeOfRole);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getInt("roleId");
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while selecting phones by employee id ", e);
            throw new RuntimeException(e);
        }
        return result;
    }


    @Override
    public int selectRoleIdByTypeOfRole(String typeOfRole, Connection connection) {
        int result = -1;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT roleid FROM roles WHERE type_of_role = ?")) {
            preparedStatement.setString(1, typeOfRole);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getInt("roleId");
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while selecting phones by employee id ", e);
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