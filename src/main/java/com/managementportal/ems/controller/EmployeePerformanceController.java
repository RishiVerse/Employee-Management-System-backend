package com.managementportal.ems.controller;

import com.managementportal.ems.Utility.GenerateReport;
import com.managementportal.ems.dto.LeaveDto;
import com.managementportal.ems.dto.PerformanceDto;
import com.managementportal.ems.dto.TestLeaves;
import com.managementportal.ems.service.LeaveService;
import com.managementportal.ems.service.WorkPerformance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class EmployeePerformanceController {


    final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private WorkPerformance workPerformance;


    // For creating leaves
    @PostMapping
    public ResponseEntity<PerformanceDto> createLeave(@RequestBody PerformanceDto performanceDto) {
        PerformanceDto createPerformance = null;
        try {
            logger.info("current leave dto inside controller {}", performanceDto);
            createPerformance = workPerformance.createWorkPerformance(performanceDto);

            logger.error("employee is created ");

        } catch (Exception e) {
            logger.error("creation of employee failed {} ", e.getMessage());
            return new ResponseEntity<>(createPerformance, HttpStatus.NO_CONTENT);

        }

        return new ResponseEntity<>(createPerformance, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<PerformanceDto> getEmployee(@PathVariable Long id) {
        PerformanceDto performanceDto = null;
        try {
            logger.info("now in finding by id stage");
            performanceDto = workPerformance.getWorkPerformanceById(id);
//            Thread thread = new Thread(new GenerateReport(workPerformance.getWorkPerformanceById(id)));
//            thread.start();
            if (performanceDto == null) {
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
    public ResponseEntity<List<PerformanceDto>> getAllEmployee() {
        List<PerformanceDto> savedPerformance = workPerformance.getAllWorkPerformance();
        //System.out.println(savedEmployee);
        return new ResponseEntity<>(savedPerformance, HttpStatus.EXPECTATION_FAILED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Boolean> updateEmployee(@PathVariable Long id, @RequestBody PerformanceDto performanceDto) {
        boolean savedPerformanceFlag = false;
        try {
            logger.info("trying to update , in controller method with id {}", id);

            savedPerformanceFlag = workPerformance.updateWorkPerformance(id, performanceDto);

            if (savedPerformanceFlag)
                return new ResponseEntity<>(savedPerformanceFlag, HttpStatus.CREATED);
            else
                return new ResponseEntity<>(savedPerformanceFlag, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {

            logger.error("updating failed, in controller method with id {}{}", id, e.getMessage());
            return new ResponseEntity<>(savedPerformanceFlag, HttpStatus.BAD_REQUEST);
        }


    }

    @DeleteMapping("{id}")
    public void updateEmployee(@PathVariable Long id) {
        workPerformance.deleteWorkPerformance(id);

    }
}
