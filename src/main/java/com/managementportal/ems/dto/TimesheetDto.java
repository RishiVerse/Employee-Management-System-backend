package com.managementportal.ems.dto;

import com.managementportal.ems.entity.EmployeeTable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class TimesheetDto {

    private int timesheetId;
    private EmployeeTable employeeDto;
    private LocalDate date;
    private double hoursWorked;
    private String projectCode;
    private String taskDescription;
    private String approvalStatus;
    private LocalDate submissionDate;
    private int approverId;
    private String comments;
}
