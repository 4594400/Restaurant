package ua.goit.java.model;


public class Role {
    private int roleID;
    private String typeOfRole;

    public Role() {
    }

    public Role(String typeOfRole) {
        this.typeOfRole = typeOfRole;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getTypeOfRole() {
        return typeOfRole;
    }

    public void setTypeOfRole(String typeOfRole) {
        this.typeOfRole = typeOfRole;
    }
}
