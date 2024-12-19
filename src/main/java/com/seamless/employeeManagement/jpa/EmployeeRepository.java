package com.seamless.employeeManagement.jpa;
import com.seamless.employeeManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "members")
// Employee is entity
// Integer is primary key like id
public interface EmployeeRepository extends JpaRepository<Employee, Integer> { }


