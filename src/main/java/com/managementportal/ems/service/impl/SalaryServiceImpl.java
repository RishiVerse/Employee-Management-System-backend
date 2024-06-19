package com.managementportal.ems.service.impl;

import com.managementportal.ems.Repository.EmployeeRepository;
import com.managementportal.ems.Repository.SalaryDataRepo;
import com.managementportal.ems.dto.SalaryDto;
import com.managementportal.ems.entity.EmployeeTable;
import com.managementportal.ems.entity.SalaryTable;

import com.managementportal.ems.service.SalaryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class SalaryServiceImpl implements SalaryService {

    final Logger logger = LoggerFactory.getLogger(SalaryServiceImpl.class);

    @Autowired
    SalaryDataRepo salaryDataRepo;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public SalaryDto createSalary(SalaryDto salaryDto) {
//        List<SalaryDto> salaryDtoList=new ArrayList<>();
        Optional<EmployeeTable> employee;
        //  employee = employeeRepository.findById(salaryDto.getEmployeeTable().getEmployeeId());
        //System.out.println(employee.get());
        SalaryTable salaryTable = modelMapper.map(salaryDto, SalaryTable.class);
        //salaryTable.setEmployeeTable(employee.get());

        salaryDataRepo.save(salaryTable);

        return modelMapper.map(salaryTable, SalaryDto.class);
    }

    @Override
    public SalaryDto getSalaryById(Long employee_id) {
        Optional<SalaryTable> salaryList = salaryDataRepo.findById(employee_id);
        SalaryTable salary = salaryList.get();
        // SalaryDto salaryDto=SalaryMapper.mapToSalaryDto(salary);
        //employee.setEmployeeTableId(salaryDto.getEmployeeTableId());
        System.out.println(salaryList);
        return modelMapper.map(salary, SalaryDto.class);
    }

    @Override
    public SalaryDto getAllSalary() {
        List<SalaryTable> salaryList = salaryDataRepo.findAll();
        System.out.println(salaryList.get(0).getEmployeeTable());
        System.out.println(salaryList.isEmpty());

        return modelMapper.map(salaryList.get(0), SalaryDto.class);
    }


    @Override
    public SalaryDto updateSalary(Long id, SalaryDto salaryDto) {
        return null;
    }

    @Override
    public void deleteSalary(Long id) {
    }
}
