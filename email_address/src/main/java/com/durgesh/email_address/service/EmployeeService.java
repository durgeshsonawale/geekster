package com.durgesh.email_address.service;

import com.durgesh.email_address.dao.EmployeeDao;
import com.durgesh.email_address.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    public ResponseEntity<List<Employee>> getAllemployees() {
        return new ResponseEntity<>(employeeDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Employee> getEmployeeById(int id) {
        return new ResponseEntity<>(employeeDao.findById(id).get(),HttpStatus.OK);
    }

    public ResponseEntity<String> createEmployee(Employee employee) {
        employeeDao.save(employee);
        String s="created succesfully";
        return new ResponseEntity<>(s,HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteEmployeeById(int id) {
        employeeDao.deleteById(id);
        String s="deleted succesfully";
        return new ResponseEntity<>(s,HttpStatus.ACCEPTED);

    }

    public ResponseEntity<String> updateEmployeeById(int id,String name) {
        Employee employee=employeeDao.findById(id).get();
        employee.setEmployeeFirstName(name);
        String s="updated succesfully";
        return new ResponseEntity<>(s,HttpStatus.ACCEPTED);

    }
}
