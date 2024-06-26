package com.managementportal.ems.service;

import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.dto.RegisterDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto empdto);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto updateEmployee(Long id,EmployeeDto empdto);
    void deleteEmployee(Long id);
    List<EmployeeDto> createBulkEmployee(List<EmployeeDto> employeeDtos);


}
