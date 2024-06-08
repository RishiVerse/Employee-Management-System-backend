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


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Timesheet {

    @Id
    private int timesheetId;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
    private LocalDate date;
    private double hoursWorked;
    private String projectCode;
    private String taskDescription;
    private String approvalStatus;
    private LocalDate submissionDate;
    private int approverId;
    private String comments;
}
