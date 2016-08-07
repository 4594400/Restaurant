package ua.goit.java.service.Impl;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.dao.PhoneDao;
import ua.goit.java.model.Employee;
import ua.goit.java.service.PhoneService;

public class PhoneServiceImpl implements PhoneService {
    private PhoneDao phoneDao;


    @Override
    @Transactional
    public int insertPhoneByEmployeeId(String phoneNumber, int employeeId){
        return phoneDao.insertPhoneByEmployeeId(phoneNumber, employeeId);
    }

    @Override
    @Transactional
    public int deletePhoneById(int id) {
        return phoneDao.deletePhoneById(id);
    }


    public void setPhoneDao(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }
}
