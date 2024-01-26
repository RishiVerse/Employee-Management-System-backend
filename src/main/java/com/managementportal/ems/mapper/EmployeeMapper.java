package com.managementportal.ems.mapper;

import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee emp)
    {
        return new EmployeeDto(emp.getId(),emp.getFirstname(), emp.getLastname(), emp.getEmail());
    }

    public static Employee mapToEmployee(EmployeeDto emp)
    {
        return new Employee(emp.getId(),emp.getFirstname(), emp.getLastname(), emp.getEmail());
    }
}
