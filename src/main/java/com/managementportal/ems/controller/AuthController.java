package com.managementportal.ems.controller;


import com.managementportal.ems.Repository.AuthService;
import com.managementportal.ems.dto.LoginDto;
import com.managementportal.ems.dto.RegisterDto;
import com.managementportal.ems.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/api/auth")
@RestController
public class AuthController {

    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<RegisterDto> register(@RequestBody RegisterDto registerDto)
    {
        RegisterDto response= userService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto)
    {
        String response= userService.login(loginDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
