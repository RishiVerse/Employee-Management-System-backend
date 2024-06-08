package com.managementportal.ems.dto;


import com.managementportal.ems.entity.Department;
import com.managementportal.ems.entity.Employee;
import com.managementportal.ems.entity.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private String emailAddress;

    private String firstname;

    private String lastname;

    private String address;

    private String mobileNumber;

    private Long employeeId;

    private List<Salaries> salary;
    private List<Leaves> leave;
    private List<WorkPerformance> workPerformances;
    private List<Timesheet> timesheets;
    private List<Department> departments;

}
