package ua.goit.java.service;

import ua.goit.java.dao.PhoneDao;
import ua.goit.java.model.Employee;

public class PhoneService {
    private PhoneDao phoneDao;

    public int insertPhoneByEmployeeId(String phoneNumber, int employeeId){
        return phoneDao.insertPhoneByEmployeeId(phoneNumber, employeeId);
    }


    public PhoneDao getPhoneDao() {
        return phoneDao;
    }

    public void setPhoneDao(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }
}
