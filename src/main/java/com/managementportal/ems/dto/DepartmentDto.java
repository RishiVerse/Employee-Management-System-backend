package com.managementportal.ems.dto;

import com.managementportal.ems.entity.EmployeeTable;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;

import java.util.List;

public class DepartmentDto {

    private String name;
    private String description;
    private List<EmployeeTable> employeeTable;
}
