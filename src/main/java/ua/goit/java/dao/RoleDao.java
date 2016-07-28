package ua.goit.java.dao;


import ua.goit.java.model.Role;

import java.sql.Connection;

public interface RoleDao {
    int selectRoleIdByTypeOfRole (String typeOfRole);
    int selectRoleIdByTypeOfRole(String typeOfRole, Connection connection);

}
