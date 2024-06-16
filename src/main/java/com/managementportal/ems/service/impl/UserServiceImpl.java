package com.managementportal.ems.service.impl;

import com.managementportal.ems.Repository.AuthService;
import com.managementportal.ems.Security.JwtTokenProvider;
import com.managementportal.ems.dto.LoginDto;
import com.managementportal.ems.dto.RegisterDto;
import com.managementportal.ems.entity.RegisterTable;
import com.managementportal.ems.exception.LoginException;
import com.managementportal.ems.exception.RegistrationException;
import com.managementportal.ems.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private AuthService authService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    @Override
    public boolean register(RegisterDto registerDto) {

        RegisterTable registerTable = new RegisterTable();

        if (Objects.equals(registerDto.getPassword(), "") ||
                Objects.equals(registerDto.getUsername(), "") ||
                Objects.equals(registerDto.getName(), "") ||
                Objects.equals(registerDto.getEmail(), "")) {

            logger.error("Error will be thrown as some value is null. Password: {} Username: {} Name: {} Email: {}",
                    registerDto.getPassword(), registerDto.getUsername(), registerDto.getName(), registerDto.getEmail());
            throw new RegistrationException("All fields are required for registration.");

        } else {


            logger.info("registration has started");

            registerTable.setEmail(registerDto.getEmail());
            registerTable.setName(registerDto.getUsername());
            if (registerDto.getPassword().length() < 7) {
                logger.error("length is less than 7");
                throw new RegistrationException("password length is less than 7 current length is : " + registerDto.getPassword().length());

            }
            registerTable.setPassword(passwordEncoder.encode(registerDto.getPassword()));
            registerTable.setName(registerDto.getName());
            authService.save(registerTable);

            logger.info("registration has ended");

        }

        logger.info("registration is successful");
        return true;
    }

    @Override
    public String login(LoginDto loginDto) {
        try {
            logger.info("login in process started");

            Authentication response = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(response);
            logger.info("login is successful");

            return jwtTokenProvider.generate(response);
        } catch (BadCredentialsException e) {
            logger.error("Invalid login credentials: {}", e.getMessage());
            throw new LoginException("password length is less than 7 current length is : ");
        } catch (Exception e) {
            logger.error("exception other than bad login credentials: {}", e.getMessage());
            throw new LoginException("Enter correct details");
        }

    }
}
