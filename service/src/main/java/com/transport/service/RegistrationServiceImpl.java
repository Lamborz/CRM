package com.transport.service;


import com.transport.form.RegistrationForm;
import com.transport.model.Employee;
import com.transport.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by 1 on 6/13/2016.
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public void addEmployee(RegistrationForm registrationForm) {

        Employee employee = new Employee();

        employee.setFirstName(registrationForm.getFirstName());
        employee.setLastName(registrationForm.getLastName());
        employee.setPosition(registrationForm.getPosition());
        employee.setMail(registrationForm.getMail());
        employee.setPhone(registrationForm.getPhone());
        employee.setRate(registrationForm.getRate());

        employee = employeeRepository.save(employee);
    }
}
