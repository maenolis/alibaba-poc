package com.baeldung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public EmployeeEntity newManager(Long managerId) {
        jdbcTemplate.update("update employee set is_manager = false where is_manager = true");
        jdbcTemplate.update("update employee set is_manager = true where id = ?", managerId);
        return jdbcTemplate.queryForObject(
            "select * from employee where id = ?",
            (rs, rowNum) -> new EmployeeEntity(
                rs.getLong("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getBoolean("is_manager")
            ),
            managerId
        );

    }

}
