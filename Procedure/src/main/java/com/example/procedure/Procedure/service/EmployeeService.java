package com.example.procedure.Procedure.service;
import com.example.procedure.Procedure.entity.Employee;
import com.example.procedure.Procedure.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
@Autowired
private EmployeeRepository employeeRepository;
    private final SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public EmployeeService(DataSource dataSource) {
        this.simpleJdbcCall = new SimpleJdbcCall(dataSource)
                .withProcedureName("getEmployeesById")
                .returningResultSet("employeeDetails", BeanPropertyRowMapper.newInstance(Employee.class));
    }

    public List<Employee> getEmployeeById(Long employeeId) {
        MapSqlParameterSource in = new MapSqlParameterSource()
                .addValue("employeeId", employeeId);

        Map<String, Object> result = simpleJdbcCall.execute(in);

        // Assuming the stored procedure returns a list of employees
        return (List<Employee>) result.get("employeeDetails");
    }


    public void insertEntity(Employee entity) {
       employeeRepository.save(entity);
    }
}
