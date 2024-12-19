package com.seamless.employeeManagement.jpa;
import com.seamless.employeeManagement.entity.Employee;
import com.seamless.employeeManagement.entity.Student;
import com.seamless.employeeManagement.exceptions.EmployeeErrorResponse;
import com.seamless.employeeManagement.exceptions.EmployeeNotFoundException;
import com.seamless.employeeManagement.jdbcTemp.JdbcDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JdbcDAO jdbcDAO;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

    // Employee not found exception
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc){
        EmployeeErrorResponse err = new EmployeeErrorResponse();
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(exc.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    // Bad request exception
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(RuntimeException exc){
        EmployeeErrorResponse err = new EmployeeErrorResponse();
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage(exc.getMessage());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    // using jdbc
    @GetMapping("/students")
    public ResponseEntity<List<Map<String, Object>>> getAllStudents() {
        return new ResponseEntity<>(jdbcDAO.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<List<Student>> getAllStudents(@PathVariable int id) {
        return new ResponseEntity<>(jdbcDAO.getStudentById(id), HttpStatus.OK);
    }

}
