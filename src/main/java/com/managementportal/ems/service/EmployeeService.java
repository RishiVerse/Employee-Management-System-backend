package com.managementportal.ems.service;

import com.managementportal.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto empdto);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto updateEmployee(EmployeeDto empdto);
    void deleteEmployee(Long id);


}
