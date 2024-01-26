package com.managementportal.ems.controller;


import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;
@PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id)
    {
        EmployeeDto savedEmployee=employeeService.getEmployeeById(id);
        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee()
    {
        List<EmployeeDto> savedEmployee=employeeService.getAllEmployee();
        return ResponseEntity.ok(savedEmployee);
    }

    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto)
    {
       EmployeeDto savedEmployee=employeeService.updateEmployee(employeeDto);
        return ResponseEntity.ok(savedEmployee);
    }

    @DeleteMapping("{id}")
    public void updateEmployee(@PathVariable Long id)
    {
        employeeService.deleteEmployee(id);

    }



}
