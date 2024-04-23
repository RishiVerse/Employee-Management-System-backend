package com.managementportal.ems.mapper;

import com.managementportal.ems.dto.SalaryDto;
import com.managementportal.ems.entity.Salaries;

public class SalaryMapper {

    public static SalaryDto mapToSalaryDto(Salaries salary)
    {
        return new SalaryDto(salary.getSalaryId(),salary.getTotal_salary(), salary.getBonus(),salary.getDeduction(),salary.getTotal_salary());
    }

    public static Salaries mapToSalary(SalaryDto salary)
    {
        return new Salaries(salary.getSalaryId(),salary.getBasic_salary(), salary.getBonus(),salary.getDeduction(),salary.getTotal_salary());
    }
}
