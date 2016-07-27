package ua.goit.java.model;


import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class Employee {
    private int empliyeeId;
    private String surname;
    private String name;
    private Date birthDay;
    private List<Phone> phone;
    private Role role;
    private double salary;

    public Employee() {
    }

    public Employee(String surname, String name, Date birthDay, List<Phone> phone, Role role, double salary) {

        this.surname = surname;
        this.name = name;
        this.birthDay = birthDay;
        this.phone = phone;
        this.role = role;
        this.salary = salary;
    }

    public int getEmpliyeeId() {
        return empliyeeId;
    }

    public void setEmpliyeeId(int empliyeeId) {
        this.empliyeeId = empliyeeId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empliyeeId=" + empliyeeId +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", phone=" + phone +
                ", role=" + role.getTypeOfRole() +
                ", salary=" + salary +
                '}';
    }
}
