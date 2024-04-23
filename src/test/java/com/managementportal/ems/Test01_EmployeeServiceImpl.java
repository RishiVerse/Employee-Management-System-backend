package com.managementportal.ems;

import com.managementportal.ems.Repository.EmployeeRepository;
import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.entity.Department;
import com.managementportal.ems.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

import static org.mockito.Mockito.mock;


@SpringBootTest
public class Test01_EmployeeServiceImpl {


    private EmployeeRepository employeeRepository;

    private EmployeeServiceImpl employeeService;
    @BeforeEach
    void setup()
    {
        this.employeeRepository=mock(EmployeeRepository.class);

        this.employeeService=new EmployeeServiceImpl(employeeRepository);
    }



    @Test
    void testCreateEmployee() {

        EmployeeDto employeeDto = new EmployeeDto("dwa@gmail.com", "mak@gmail.com",
                "kks", "manas"
                , "323232", 300789L,new HashSet<>());


        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);

        Assertions.assertEquals(employeeDto.getEmployeeId(), savedEmployee.getEmployeeId());
        Assertions.assertEquals(employeeDto.getEmailAddress(), savedEmployee.getEmailAddress());
        Assertions.assertEquals(employeeDto.getFirstname(), savedEmployee.getFirstname());
        Assertions.assertEquals(employeeDto.getLastname(), savedEmployee.getLastname());
        Assertions.assertEquals(employeeDto.getAddress(), savedEmployee.getAddress());
        Assertions.assertEquals(employeeDto.getMobileNumber(), savedEmployee.getMobileNumber());
        Assertions.assertEquals(employeeDto.getDepartmentId(), savedEmployee.getDepartmentId());
        Assertions.assertEquals(employeeDto.getId(), savedEmployee.getId());

    }


}
