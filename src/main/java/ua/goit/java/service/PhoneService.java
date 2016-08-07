package ua.goit.java.service;

public interface PhoneService {

    int insertPhoneByEmployeeId(String phoneNumber, int employeeId);

    int deletePhoneById(int id);
}
