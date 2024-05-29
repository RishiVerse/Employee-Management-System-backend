package com.managementportal.ems.service.impl;

import com.managementportal.ems.Repository.AuthService;
import com.managementportal.ems.dto.LoginDto;
import com.managementportal.ems.dto.RegisterDto;
import com.managementportal.ems.entity.Register;
import com.managementportal.ems.mapper.RegisterMapper;
import com.managementportal.ems.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private AuthService authService;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;





    @Override
    public RegisterDto register(RegisterDto registerDto) {
        Register register= new Register();
        register.setEmail(registerDto.getEmail());
        register.setName(registerDto.getUsername());
        register.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        register.setName(registerDto.getName());
        authService.save(register);
        return RegisterMapper.mapToRegisterDto(register);
    }

    @Override
    public String login(LoginDto loginDto) {
        Authentication response = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(response);
        return "login success";    }
}
