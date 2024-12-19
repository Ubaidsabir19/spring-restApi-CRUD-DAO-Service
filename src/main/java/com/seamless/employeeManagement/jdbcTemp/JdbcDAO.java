package com.seamless.employeeManagement.jdbcTemp;

import com.seamless.employeeManagement.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class JdbcDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getAllStudents(){
        String insertQuery = "SELECT * FROM student";
        List<Map<String, Object>> student = jdbcTemplate.queryForList(insertQuery);
        System.out.println(student);
        return student;
    }

    public List<Student> getStudentById(int id){
        String query = "SELECT * FROM student WHERE id = ?";
        return jdbcTemplate.query(query, new Object[]{id}, new StudentRowMapper());
    }
}
