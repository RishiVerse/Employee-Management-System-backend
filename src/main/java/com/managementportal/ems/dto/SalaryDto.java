package com.managementportal.ems.dto;


import com.managementportal.ems.entity.Employee;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SalaryDto {

    private Long salaryId;
    private Employee employeeId;
    private Long basic_salary;
    private Long bonus;
    private Long deduction;
    private Long total_salary;


}
