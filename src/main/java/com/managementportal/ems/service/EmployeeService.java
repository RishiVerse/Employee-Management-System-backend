package com.managementportal.ems.service;

import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.dto.RegisterDto;

import java.util.List;

public interface EmployeeService {
    boolean createEmployee(EmployeeDto empdto);

    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto> getAllEmployee();

    Boolean updateEmployee(Long id, EmployeeDto empdto);

    boolean deleteEmployee(Long id);

    List<EmployeeDto> createBulkEmployee(List<EmployeeDto> employeeDtos);


}
