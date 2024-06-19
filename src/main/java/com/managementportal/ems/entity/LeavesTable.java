package com.managementportal.ems.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LeavesTable {

    @Id
    private int leaveId;
    @ManyToOne
    @JoinColumn(name = "employeeTableId")
    private EmployeeTable employeeTableId;
    private String leaveType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String leaveReason;
    private String approvalStatus;
    private int numberOfDays;

    @Override
    public String toString() {
        return "LeavesTable{" +
                "leaveId=" + leaveId +
                ", employeeTableId=" + employeeTableId +
                ", leaveType='" + leaveType + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", leaveReason='" + leaveReason + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", numberOfDays=" + numberOfDays +
                '}';
    }
}
