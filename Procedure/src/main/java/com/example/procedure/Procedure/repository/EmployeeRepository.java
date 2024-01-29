package com.example.procedure.Procedure.repository;

import com.example.procedure.Procedure.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
