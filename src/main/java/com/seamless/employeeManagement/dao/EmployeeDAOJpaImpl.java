package com.seamless.employeeManagement.dao;
import com.seamless.employeeManagement.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager empEntity){
        entityManager = empEntity;
    }

    @Override
    public List<Employee> findAll() {

        // Create the query
        TypedQuery<Employee> typedQuery = entityManager.createQuery("from Employee", Employee.class);

        // Execute the query
        List<Employee> employees = typedQuery.getResultList();

        // return the query
        return employees;
    }

}
