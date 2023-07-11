package com.durgesh.email_address.dao;

import com.durgesh.email_address.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {
}
