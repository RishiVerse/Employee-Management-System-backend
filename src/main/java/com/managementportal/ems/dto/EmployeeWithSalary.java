package com.managementportal.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeWithSalary {

    private String firstname;
    private String lastname;
    private String email;
    private Long basicSalary;


}
