package com.managementportal.ems.service;

import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.dto.LoginDto;
import com.managementportal.ems.dto.RegisterDto;

import java.util.List;

public interface UserService {
    boolean register(RegisterDto registerDto);

    String login(LoginDto loginDto);


    }
