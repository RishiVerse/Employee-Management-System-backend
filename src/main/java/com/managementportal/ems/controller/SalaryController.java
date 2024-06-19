package com.managementportal.ems.controller;


import com.managementportal.ems.dto.SalaryDto;
import com.managementportal.ems.service.SalaryService;
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
@RequestMapping("/api/employees/salary")
public class SalaryController {

    final Logger logger = LoggerFactory.getLogger(SalaryController.class);


    @Autowired
    private SalaryService salaryService;

    @PostMapping
    public ResponseEntity<SalaryDto> createSalary(@RequestBody SalaryDto salaryDto) {

        SalaryDto savedSalary = salaryService.createSalary(salaryDto);
        return new ResponseEntity<>(savedSalary, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SalaryDto> getSalaryById(@PathVariable Long id) {
        SalaryDto savedEmployee = salaryService.getSalaryById(id);

        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping
    public ResponseEntity<SalaryDto> getAllSalary() {
        SalaryDto savedSalary = null;
        try {
            logger.info("inside try block to find salary in controller method");
            savedSalary = salaryService.getAllSalary();

        } catch (Exception e) {
            logger.error("something went wrong in controller method");
            return ResponseEntity.ok(savedSalary);

        }
        // System.out.println(savedSalary);


        return ResponseEntity.ok(savedSalary);
    }

    @PutMapping("{employee_id}")
    public ResponseEntity<SalaryDto> updateSalary(@PathVariable Long employee_id, @RequestBody SalaryDto salaryDto) {
        SalaryDto savedSalary = salaryService.updateSalary(employee_id, salaryDto);
        return ResponseEntity.ok(savedSalary);
    }

    @DeleteMapping("{employee_id}")
    public void deleteSalary(@PathVariable Long employee_id) {
        salaryService.deleteSalary(employee_id);
    }


}
