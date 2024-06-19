package com.managementportal.ems.dto;

import com.managementportal.ems.entity.EmployeeTable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LeaveDto {


    private int leaveId;
    private String leaveType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String leaveReason;
    private String approvalStatus;
    private int numberOfDays;
    private EmployeeTable employeeTableId;
//
//    @Override
//    public String toString() {
//        return "LeaveDto{" +
//                "leaveId=" + leaveId +
//                ", employeeTableId=" + employeeTableId +
//                ", leaveType='" + leaveType + '\'' +
//                ", startDate=" + startDate +
//                ", endDate=" + endDate +
//                ", leaveReason='" + leaveReason + '\'' +
//                ", approvalStatus='" + approvalStatus + '\'' +
//                ", numberOfDays=" + numberOfDays +
//                '}';
//    }
}
