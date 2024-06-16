package com.managementportal.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class EmployeeTable {
    private String email;

    private String firstname;

    private String lastname;

    private String address;

    private String mobileNumber;

    @Id
    private Long employeeId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeTable")
    private List<SalaryTable> salary;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeTableId")
    private List<LeavesTable> leave;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeTable")
    private List<WorkPerformanceTable> workPerformanceTables;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeTable")
    private List<TimesheetTable> timesheetTables;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "employeeTable")
    private List<DepartmentTable> departments;


}


