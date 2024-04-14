package com.managementportal.ems.service;

import com.managementportal.ems.dto.SalaryDto;

import java.util.List;

public interface EmployeeDataService {

    SalaryDto createSalary(SalaryDto salaryDto);
    SalaryDto getSalaryById(Long id);
    List<SalaryDto> getAllSalary();
    SalaryDto updateSalary(Long id, SalaryDto salaryDto);
    void deleteSalary(Long id);
}
