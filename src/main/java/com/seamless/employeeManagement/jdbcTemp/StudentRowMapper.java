package com.seamless.employeeManagement.jdbcTemp;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.seamless.employeeManagement.entity.Student;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setFirst_name(rs.getString("first_name"));
        student.setLast_name(rs.getString("last_name"));
        student.setEmail(rs.getString("email"));
        return student;
    }
}

