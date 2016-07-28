package ua.goit.java.dao;


import ua.goit.java.model.Role;

public interface RoleDao {
    int selectRoleIdByTypeOfRole (String typeOfRole);

}
