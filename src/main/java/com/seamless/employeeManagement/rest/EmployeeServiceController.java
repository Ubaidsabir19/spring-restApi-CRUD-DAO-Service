package com.seamless.employeeManagement.rest;
import com.seamless.employeeManagement.entity.Employee;
import com.seamless.employeeManagement.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeServiceController {

    public EmployeeService employeeService;

    public EmployeeServiceController(EmployeeService empService){
        employeeService = empService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if (employee == null){
            throw new RuntimeException("Employee id not found: " + id);
        }
        return employee;
    }





}
