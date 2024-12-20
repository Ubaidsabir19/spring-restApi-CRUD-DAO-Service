package com.seamless.employeeManagement.jpa;
import com.seamless.employeeManagement.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> { }
