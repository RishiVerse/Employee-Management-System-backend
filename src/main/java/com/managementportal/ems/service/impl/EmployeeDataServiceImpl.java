package com.managementportal.ems.service.impl;

import com.managementportal.ems.Repository.EmployeeRepository;
import com.managementportal.ems.Repository.SalaryDataRepo;
import com.managementportal.ems.dto.SalaryDto;
import com.managementportal.ems.entity.Employee;
import com.managementportal.ems.entity.Salaries;
import com.managementportal.ems.mapper.EmployeeMapper;
import com.managementportal.ems.mapper.SalaryMapper;
import com.managementportal.ems.service.EmployeeDataService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeDataServiceImpl implements EmployeeDataService {
    SalaryDataRepo salaryDataRepo;

    EmployeeRepository employeeRepository;
    @Override
    public SalaryDto createSalary(SalaryDto salaryDto) {
        return null;
    }

    @Override
    public SalaryDto getSalaryById(Long id) {
        return null;
    }

    @Override
    public List<SalaryDto> getAllSalary() {

        List<Salaries> salary=salaryDataRepo.findAll();

        List<SalaryDto> salaryDto=salary.stream().map(SalaryMapper::mapToSalaryDto).toList();

        return salary.stream().map(SalaryMapper::mapToSalaryDto).collect(Collectors.toList());
       // return List.of();
    }

    @Override
    public SalaryDto updateSalary(Long id, SalaryDto salaryDto) {
        return null;
    }

    @Override
    public void deleteSalary(Long id) {

    }
}
