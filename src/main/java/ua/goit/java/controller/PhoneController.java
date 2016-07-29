package ua.goit.java.controller;


import ua.goit.java.model.Employee;
import ua.goit.java.service.PhoneService;

public class PhoneController {
    PhoneService phoneService;

    public void printInsertedPhoneByEmployeeId(String phoneNumber, int employeeId) {
        System.out.println(phoneService.insertPhoneByEmployeeId(phoneNumber, employeeId) + " phoneNumber: " + phoneNumber + " was added to employee with id: " + employeeId);
    }

    public void printResultDeletedPhoneById(int id) {
        System.out.println("-------------------- printResultDeletedPhoneById --------------------------------------------------------------------------------------------------");
        System.out.println(phoneService.deletePhoneById(id) + " phone with id = " + id + " was deleted");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");

    }


    public PhoneService getPhoneService() {
        return phoneService;
    }

    public void setPhoneService(PhoneService phoneService) {
        this.phoneService = phoneService;
    }
}
