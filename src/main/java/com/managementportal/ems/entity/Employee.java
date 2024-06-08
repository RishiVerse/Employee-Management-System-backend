package com.managementportal.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.List;
import java.util.Set;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    private String email;

    private String firstname;

    private String lastname;

    private String address;

    private String mobileNumber;

    @Id
    private Long employeeId;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
    private List<Salaries> salary;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employeeId")
    private List<Leaves> leave;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
    private List<WorkPerformance> workPerformances;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
    private List<Timesheet> timesheets;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "employees")
    private List<Department> departments;




}


