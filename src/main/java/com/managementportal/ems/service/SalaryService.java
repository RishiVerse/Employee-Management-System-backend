package com.managementportal.ems.service;

import com.managementportal.ems.dto.EmployeeWithSalary;
import com.managementportal.ems.dto.SalaryDto;

import java.util.List;

public interface SalaryService {

    List<EmployeeWithSalary> employeeSalary(int employeeId);

    SalaryDto createSalary(SalaryDto salaryDto);

    SalaryDto getSalaryById(Long id);

    SalaryDto getAllSalary();

    SalaryDto updateSalary(Long id, SalaryDto salaryDto);

    void deleteSalary(Long id);
}
