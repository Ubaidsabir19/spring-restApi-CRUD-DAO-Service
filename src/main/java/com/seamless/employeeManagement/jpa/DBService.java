package com.seamless.employeeManagement.jpa;

import com.seamless.employeeManagement.entity.Address;
import com.seamless.employeeManagement.entity.Department;
import com.seamless.employeeManagement.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DBService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Autowired
    private final AddressRepository addressRepository;

    @Autowired
    private final DepartmentRepository departmentRepository;

    // Constructor
    public DBService(EmployeeRepository employeeRepository, AddressRepository addressRepository, DepartmentRepository departmentRepository){
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
        this.departmentRepository = departmentRepository;
    }

    // Get all Logics--------------------------
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }

    // Get by id Logic--------------------------------
    public Employee getEmployeeById(int id){
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
    }

    // Save Methods-------------------------------------
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Update Employee Method-------------------------------------
    public Employee updateEmployee(int id, Employee updatedEmployee) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setFirst_name(updatedEmployee.getFirst_name());
                    employee.setLast_name(updatedEmployee.getLast_name());
                    employee.setEmail(updatedEmployee.getEmail());
                    employee.setAddress(updatedEmployee.getAddress());
                    return employeeRepository.save(employee);
                }).orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    // Assign department method-------------------------------------
    public Employee assignDepartment(int employeeId, int departmentId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new RuntimeException("Department not found"));
        employee.getDepartments().add(department);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
