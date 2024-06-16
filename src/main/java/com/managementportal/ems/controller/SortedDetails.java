package com.managementportal.ems.controller;


import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/employees/sortedEmployee")
public class SortedDetails {

    final Logger logger = LoggerFactory.getLogger(SortedDetails.class);

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDto> sortedEmployee(@RequestParam String sortedBy) {
        final Logger logger = LoggerFactory.getLogger(SortedDetails.class);

        List<EmployeeDto> savedEmployee = employeeService.getAllEmployee();

        switch (sortedBy) {
            case "email": {
                try {
                    logger.info("\n****** email sorting *******\n");
                    savedEmployee.sort(Comparator.comparing(EmployeeDto::getEmailAddress));
                    break;
                } catch (Exception e) {
                    logger.error("\nError sorting employees by {}: {}", sortedBy, e.getMessage(), e);
                }

            }
            case "firstname": {

                try {
                    logger.info("\n*******  firstname sorting *******\n");

                    savedEmployee.sort(Comparator.comparing(EmployeeDto::getFirstname));
                    break;
                } catch (Exception e) {
                    logger.error("\nError sorting employees by {}: {}", sortedBy, e.getMessage(), e);

                }
            }
            case "lastname": {
                try {
                    logger.info("\n******* lastname sorting *******\n");

                    savedEmployee.sort(Comparator.comparing(EmployeeDto::getLastname));
                    break;
                } catch (Exception e) {
                    logger.error("\nError sorting employees by {}: {}", sortedBy, e.getMessage(), e);
                }

            }
            default: {
                try {
                    logger.info("\n******* employeeId sorting *******\n");

                    savedEmployee.sort(Comparator.comparing(EmployeeDto::getEmployeeId));
                } catch (Exception e) {
                    logger.error("\nError sorting employees by {}: {}", sortedBy, e.getMessage(), e);

                }
            }

        }

        return savedEmployee;
    }
}
