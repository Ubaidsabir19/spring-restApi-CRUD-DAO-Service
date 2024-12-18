package com.seamless.employeeManagement.dao;
import com.seamless.employeeManagement.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
