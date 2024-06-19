package com.managementportal.ems.dto;

import com.managementportal.ems.entity.EmployeeTable;

import java.time.LocalDate;

public class PerformanceDto {

    private EmployeeTable employeeTable;
    private String employeeName;
    private String department;
    private String jobTitle;
    private LocalDate dateOfJoining;
    private String managerName;

    // Performance-related attributes
    private double performanceRating;
    private int projectsCompleted;
    private int tasksCompleted;
    private int hoursWorked;
    private int daysAbsent;
    private LocalDate lastPerformanceReviewDate;
    private String performanceFeedback;
    private boolean isEligibleForPromotion;
    private double salaryIncrement;

}
