package com.seamless.employeeManagement.rest;

import com.seamless.employeeManagement.dao.EmployeeDAO;
import com.seamless.employeeManagement.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    public EmployeeDAO employeeDAO;

    public EmployeeRestController(EmployeeDAO empDao){
        employeeDAO = empDao;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

}
