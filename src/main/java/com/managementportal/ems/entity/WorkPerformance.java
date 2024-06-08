package com.managementportal.ems.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class WorkPerformance {

    @Id
    private int PerformanceId;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
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
