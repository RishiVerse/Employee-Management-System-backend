package com.managementportal.ems.mapper;

import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.dto.RegisterDto;
import com.managementportal.ems.entity.Register;

public class RegisterMapper {
    public static RegisterDto mapToRegisterDto(Register register)
    {
        return new RegisterDto(register.getName(), register.getUsername(), register.getEmail(), register.getPassword());
    }

    public static Register mapToEmployee(RegisterDto registerdto)
    {
        return new Register(registerdto.getName(), registerdto.getUsername(), registerdto.getEmail(), registerdto.getPassword());
    }
}
