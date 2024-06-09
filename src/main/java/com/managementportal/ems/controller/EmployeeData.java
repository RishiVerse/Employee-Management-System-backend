package com.managementportal.ems.controller;


import com.managementportal.ems.dto.SalaryDto;
import com.managementportal.ems.entity.Salaries;
import com.managementportal.ems.service.EmployeeDataService;
import com.managementportal.ems.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/employees/data")
public class EmployeeData {

    final Logger logger = LoggerFactory.getLogger(EmployeeData.class);

    @Autowired
    private EmployeeDataService employeeDataService;

    @PostMapping
    public ResponseEntity<SalaryDto> createEmployee(@RequestBody SalaryDto salaryDto) {

        SalaryDto savedSalary = employeeDataService.createSalary(salaryDto);
        return new ResponseEntity<>(savedSalary, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SalaryDto> getEmployee(@PathVariable Long id) {
        SalaryDto savedEmployee = employeeDataService.getSalaryById(id);
        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping
    public ResponseEntity<List<SalaryDto>> getAllSalary() {
        List<SalaryDto> savedSalary = employeeDataService.getAllSalary();
        System.out.println(savedSalary);
        return ResponseEntity.ok(savedSalary);
    }

    @PutMapping("{employee_id}")
    public ResponseEntity<SalaryDto> updateEmployee(@PathVariable Long employee_id, @RequestBody SalaryDto salaryDto) {
        SalaryDto savedSalary = employeeDataService.updateSalary(employee_id, salaryDto);
        return ResponseEntity.ok(savedSalary);
    }

    @DeleteMapping("{employee_id}")
    public void deleteSalary(@PathVariable Long employee_id) {
        employeeDataService.deleteSalary(employee_id);
    }


}
