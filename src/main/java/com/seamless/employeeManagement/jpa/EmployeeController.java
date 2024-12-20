package com.seamless.employeeManagement.jpa;
import com.seamless.employeeManagement.entity.Address;
import com.seamless.employeeManagement.entity.Department;
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

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private DBService dbService;

    @Autowired
    private JdbcDAO jdbcDAO;

    // Get All endpoints-----------------------------
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return dbService.getAllEmployees();
    }

    @GetMapping("/department")
    public List<Department> getAllDepartment(){
        return dbService.getAllDepartments();
    }

    @GetMapping("/address")
    public List<Address> getAllAddress(){
        return dbService.getAllAddresses();
    }

    // Get by id ------------------------------------

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return dbService.getEmployeeById(id);
    }

    // Post Methods------------------------------------
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return dbService.saveEmployee(employee);
    }

    @PostMapping("/department")
    public Department addDepartment(@RequestBody Department department){
        return dbService.saveDepartment(department);
    }

    @PostMapping("/{employeeId}/addresses")
    public ResponseEntity<Address> addAddress(@PathVariable int employeeId, @RequestBody Address address) {
        Employee employee = dbService.getEmployeeById(employeeId);
        address.setEmployee(employee);
        Address savedAddress = dbService.saveAddress(address);
        return ResponseEntity.ok(savedAddress);
    }

    // Assign a Department to an Employee
    @PostMapping("/{employeeId}/departments/{departmentId}")
    public ResponseEntity<Employee> assignDepartment(@PathVariable int employeeId, @PathVariable int departmentId) {
        Employee updatedEmployee = dbService.assignDepartment(employeeId, departmentId);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Update Methods-----------------------------------
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        return dbService.updateEmployee(id, updatedEmployee);
    }

    // Delete Methods------------------------------------
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        dbService.deleteEmployee(id);
    }
    //------------------------------------------
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

    // using jdbc Temp
    @GetMapping("/students")
    public ResponseEntity<List<Map<String, Object>>> getAllStudents() {
        return new ResponseEntity<>(jdbcDAO.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<List<Student>> getAllStudents(@PathVariable int id) {
        return new ResponseEntity<>(jdbcDAO.getStudentById(id), HttpStatus.OK);
    }

}
