package com.managementportal.ems.controller;


import com.managementportal.ems.dto.LeaveDto;
import com.managementportal.ems.dto.TestLeaves;
import com.managementportal.ems.service.LeaveService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/leaves")
public class LeaveController {


    final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private LeaveService leaveService;


    // For creating leaves
    @PostMapping
    public ResponseEntity<LeaveDto> createLeave(@RequestBody LeaveDto leaveDto) {
        LeaveDto createdLeave = null;
        try {
            logger.info("current leave dto inside controller {}", leaveDto);
            createdLeave = leaveService.createLeave(leaveDto);

            logger.error("employee is created ");

        } catch (Exception e) {
            logger.error("creation of employee failed {} ", e.getMessage());
            return new ResponseEntity<>(createdLeave, HttpStatus.NO_CONTENT);

        }

        return new ResponseEntity<>(createdLeave, HttpStatus.CREATED);
    }


    // For adding bulk users

//    @PostMapping("/bulk")
//    public ResponseEntity<List<EmployeeDto>> createBulkEmployee(@RequestBody List<EmployeeDto> employeeDto) {
//        List<EmployeeDto> savedEmployee = employeeService.createBulkEmployee(employeeDto);
//        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id) {
//        EmployeeDto byIdFlag = null;
//        try {
//            logger.info("now in finding by id stage");
//            byIdFlag = employeeService.getEmployeeById(id);
//            Thread thread = new Thread(new GenerateReport(employeeService.getEmployeeById(id)));
//            thread.start();
//            if (byIdFlag == null) {
//                logger.error("no employee available with  , id {}", id);
//                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
//
//            }
//            return new ResponseEntity<>(null, HttpStatus.CREATED);
//
//
//        } catch (Exception e) {
//            logger.error("error in finding employee in controller class , id {}", id);
//            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
//        }
//    }

    @GetMapping
    public ResponseEntity<List<TestLeaves>> getAllEmployee() {
        List<TestLeaves> savedEmployee = leaveService.getAllLeaves();
        System.out.println(savedEmployee);
        return ResponseEntity.ok(savedEmployee);
    }

//    @PutMapping("{id}")
//    public ResponseEntity<Boolean> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
//        boolean savedEmployeeFlag = false;
//        try {
//            logger.info("trying to update , in controller method with id {}", id);
//
//            savedEmployeeFlag = employeeService.updateEmployee(id, employeeDto);
//
//            if (savedEmployeeFlag)
//                return new ResponseEntity<>(savedEmployeeFlag, HttpStatus.CREATED);
//            else
//                return new ResponseEntity<>(savedEmployeeFlag, HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//
//            logger.error("updating failed, in controller method with id {}{}", id, e.getMessage());
//            return new ResponseEntity<>(savedEmployeeFlag, HttpStatus.BAD_REQUEST);
//        }
//
//
//    }
//
//    @DeleteMapping("{id}")
//    public void updateEmployee(@PathVariable Long id) {
//        employeeService.deleteEmployee(id);
//
//    }

}
