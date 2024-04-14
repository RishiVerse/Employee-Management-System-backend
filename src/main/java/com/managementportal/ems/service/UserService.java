package com.managementportal.ems.service;

import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.dto.LoginDto;
import com.managementportal.ems.dto.RegisterDto;

public interface UserService {
    RegisterDto register(RegisterDto registerDto);

    String login(LoginDto loginDto);

}
