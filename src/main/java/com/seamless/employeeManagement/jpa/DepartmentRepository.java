package com.seamless.employeeManagement.jpa;

import com.seamless.employeeManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> { }
