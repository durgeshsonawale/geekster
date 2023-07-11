package com.durgesh.email_address.controller;

import com.durgesh.email_address.entity.Employee;
import com.durgesh.email_address.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("employess")
public class EmployeeController {
    /*
    GET /employees - get all employees
GET /employees/{id} - get an employee by id
POST /employees - create a new employee
PUT /employees/{id} - update an employee by id
DELETE /employees/{id} - delete an employee by id
     */
    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return employeeService.getAllemployees();
    }
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }
    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable int id){
        return employeeService.deleteEmployeeById(id);
    }
    @PutMapping("{id}/{name}")
    public ResponseEntity<String> updateEmployeeById(@PathVariable int id ,@PathVariable String name) {
        return employeeService.updateEmployeeById(id,name);
    }

}
