package com.managementportal.ems.mapper;

import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee emp)
    {
        return new EmployeeDto(emp.getEmail(),emp.getFirstname(), emp.getLastname(),emp.getAddress(),emp.getMobileNumber(),emp.getEmployeeId(),emp.getSalaries());
    }

    public static Employee mapToEmployee(EmployeeDto emp)
    {
        return new Employee(emp.getEmailAddress(),emp.getFirstname(), emp.getLastname(),emp.getAddress(),emp.getMobileNumber(),emp.getEmployeeId(),emp.getSalaries());
    }

}
