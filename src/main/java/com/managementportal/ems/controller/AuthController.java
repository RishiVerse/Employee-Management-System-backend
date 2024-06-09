package com.managementportal.ems.controller;

import com.managementportal.ems.dto.JwtAuthResponse;
import com.managementportal.ems.dto.LoginDto;
import com.managementportal.ems.dto.RegisterDto;
import com.managementportal.ems.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private final UserService userService;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager manager;



    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@RequestBody RegisterDto registerDto) {
        boolean response = false;
        try {
            response = userService.register(registerDto);
            if(!response) {
                return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
            }
        }
        catch (Exception e)
        {
            logger.error("Can not register :  {}",e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto) {
        String token = userService.login(loginDto);
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }
}
