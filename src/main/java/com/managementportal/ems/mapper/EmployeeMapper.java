package com.managementportal.ems.mapper;

import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee emp)
    {
        return new EmployeeDto(emp.getId(),emp.getEmail(),emp.getFirstname(), emp.getLastname(),emp.getDepartment_Id(),emp.getAddress(),emp.getMobileNumber(),emp.getEmployeeId());
    }

    public static Employee mapToEmployee(EmployeeDto emp)
    {
        return new Employee(emp.getId(),emp.getEmailAddress(),emp.getFirstname(), emp.getLastname(),emp.getDepartmentId(),emp.getAddress(),emp.getMobileNumber(),emp.getEmployeeId());
    }

}
