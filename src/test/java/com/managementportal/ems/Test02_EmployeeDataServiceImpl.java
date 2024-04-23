package com.managementportal.ems;

import com.managementportal.ems.Repository.SalaryDataRepo;
import com.managementportal.ems.dto.SalaryDto;
import com.managementportal.ems.entity.Salaries;
import com.managementportal.ems.mapper.SalaryMapper;
import com.managementportal.ems.service.impl.EmployeeDataServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.mock;

public class Test02_EmployeeDataServiceImpl {

    EmployeeDataServiceImpl employeeDataService;
    SalaryDataRepo salaryDataRepo;
    @BeforeEach
     void setup() {
      this.salaryDataRepo=mock(SalaryDataRepo.class);
      this.employeeDataService=new EmployeeDataServiceImpl(salaryDataRepo);

    }

    @Test
    void name() {

        Optional<Salaries> salaryList = salaryDataRepo.findById(2008917L);
        Salaries salary=salaryList.get();
        SalaryDto salaryDto= SalaryMapper.mapToSalaryDto(salary);

        Assertions.assertEquals(3237654L,salaryDto.getBasic_salary());
        // Assertions.assertEquals(2008917L,salaryDto.getEmployeeId());
        Assertions.assertEquals(543231L,salaryDto.getTotal_salary());
        Assertions.assertEquals(32771L,salaryDto.getBonus());
        Assertions.assertEquals(316432L,salaryDto.getDeduction());




    }
}
