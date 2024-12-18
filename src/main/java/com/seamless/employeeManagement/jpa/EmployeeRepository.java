package com.seamless.employeeManagement.jpa;
import com.seamless.employeeManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> { }


