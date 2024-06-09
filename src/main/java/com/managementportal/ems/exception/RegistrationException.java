package com.managementportal.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
public class RegistrationException extends RuntimeException{

    public RegistrationException(String message)
    {
        super(message);
    }



}