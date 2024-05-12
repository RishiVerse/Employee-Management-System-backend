package com.managementportal.ems.controller;


import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // For creating an employee

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    // For adding bulk users

    @PostMapping("bulk")
    public ResponseEntity<List<EmployeeDto>> createBulkEmployee(@RequestBody List<EmployeeDto> employeeDto)
    {
        List<EmployeeDto> savedEmployee=employeeService.createBulkEmployee(employeeDto);
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
        System.out.println(savedEmployee);
        return ResponseEntity.ok(savedEmployee);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,@RequestBody EmployeeDto employeeDto)
    {
       EmployeeDto savedEmployee=employeeService.updateEmployee(id,employeeDto);
        return ResponseEntity.ok(savedEmployee);
    }

    @DeleteMapping("{id}")
    public void updateEmployee(@PathVariable Long id)
    {
        employeeService.deleteEmployee(id);

    }





}
