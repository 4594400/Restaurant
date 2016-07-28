package ua.goit.java.controller;


import ua.goit.java.model.Employee;
import ua.goit.java.service.PhoneService;

public class PhoneController {
    PhoneService phoneService;

    public void printInsertedPhoneByEmployeeId(String phoneNumber, int employeeId) {
        System.out.println(phoneService.insertPhoneByEmployeeId(phoneNumber, employeeId) + " phoneNumber: " + phoneNumber + " was added to employee with id: " + employeeId);
    }


    public PhoneService getPhoneService() {
        return phoneService;
    }

    public void setPhoneService(PhoneService phoneService) {
        this.phoneService = phoneService;
    }
}
