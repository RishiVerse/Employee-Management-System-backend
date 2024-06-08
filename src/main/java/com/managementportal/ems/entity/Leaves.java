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


@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Leaves {

    @Id
    private int leaveId;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employeeId;
    private String leaveType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String leaveReason;
    private String approvalStatus;
    private int numberOfDays;
}
