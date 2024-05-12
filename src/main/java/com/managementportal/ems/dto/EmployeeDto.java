package com.managementportal.ems.dto;


import com.managementportal.ems.entity.Department;
import com.managementportal.ems.entity.Salaries;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    //private Department departmentId;

    private String address;

    private String mobileNumber;

    private Long employeeId;

    private Set<Salaries> salaries;
   // private List<Salaries> salaries;


}
