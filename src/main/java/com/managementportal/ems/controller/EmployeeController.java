package com.managementportal.ems.controller;


import com.managementportal.ems.Threads.GenerateReport;
import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.service.EmployeeService;
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
@RequestMapping("/api/employees")
public class EmployeeController {

    final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;


    // For creating an employee
    @PostMapping
    public ResponseEntity<Boolean> createEmployee(@RequestBody EmployeeDto employeeDto) {
        boolean saveFlag = false;
        try {

            saveFlag = employeeService.createEmployee(employeeDto);

            logger.error("employee is created ");

        } catch (Exception e) {
            logger.error("creation of employee failed {} ", e.getMessage());
            return new ResponseEntity<>(saveFlag, HttpStatus.NO_CONTENT);

        }

        return new ResponseEntity<>(saveFlag, HttpStatus.CREATED);
    }


    // For adding bulk users

    @PostMapping("bulk")
    public ResponseEntity<List<EmployeeDto>> createBulkEmployee(@RequestBody List<EmployeeDto> employeeDto) {
        List<EmployeeDto> savedEmployee = employeeService.createBulkEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id) {
        EmployeeDto byIdFlag = null;
        try {
            byIdFlag = employeeService.getEmployeeById(id);
//            Thread thread = new Thread(new GenerateReport(employeeService.getEmployeeById(id)));
//            thread.start();
            if (byIdFlag == null) {
                logger.error("no employee available with  , id {}", id);
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

            }
            return new ResponseEntity<>(null, HttpStatus.CREATED);


        } catch (Exception e) {
            logger.error("error in finding employee in controller class , id {}", id);
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee() {
        List<EmployeeDto> savedEmployee = employeeService.getAllEmployee();
        System.out.println(savedEmployee);

        return ResponseEntity.ok(savedEmployee);
    }

    @PutMapping("{id}")
    public ResponseEntity<Boolean> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        boolean savedEmployeeFlag = false;
        try {
            logger.info("trying to update , in controller method with id {}", id);

            savedEmployeeFlag = employeeService.updateEmployee(id, employeeDto);

            if (savedEmployeeFlag)
                return new ResponseEntity<>(savedEmployeeFlag, HttpStatus.CREATED);
            else
                return new ResponseEntity<>(savedEmployeeFlag, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {

            logger.error("updating failed, in controller method with id {}{}", id, e.getMessage());
            return new ResponseEntity<>(savedEmployeeFlag, HttpStatus.BAD_REQUEST);
        }


    }

    @DeleteMapping("{id}")
    public void updateEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);

    }


}
