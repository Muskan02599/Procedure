package com.example.procedure.Procedure.controller;

import com.example.procedure.Procedure.entity.Employee;
import com.example.procedure.Procedure.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public List<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/insert")
    public void insertEntity(@RequestBody Employee entity) {
        employeeService.insertEntity(entity);
    }
}
