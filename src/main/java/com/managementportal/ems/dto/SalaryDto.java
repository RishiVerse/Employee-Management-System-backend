package com.managementportal.ems.dto;


import com.managementportal.ems.entity.Employee;
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
    private Long basic_salary;
    private Long bonus;
    private Long deduction;
    private Long total_salary;

//    @Override
//    public String toString() {
//        return "SalaryDto{" +
//                "employeeId=" + employeeId +
//                '}';
//    }
}
