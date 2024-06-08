package com.managementportal.ems.service.impl;

import com.managementportal.ems.Repository.EmployeeRepository;
import com.managementportal.ems.Repository.SalaryDataRepo;
import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.dto.SalaryDto;
import com.managementportal.ems.entity.Department;
import com.managementportal.ems.entity.Employee;
import com.managementportal.ems.entity.Salaries;

import com.managementportal.ems.service.EmployeeDataService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeDataServiceImpl implements EmployeeDataService {

    @Autowired
    SalaryDataRepo salaryDataRepo;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public SalaryDto createSalary(SalaryDto salaryDto) {
//        List<SalaryDto> salaryDtoList=new ArrayList<>();
        new Employee();
        Optional<Employee> employee;
         employee = employeeRepository.findById(salaryDto.getEmployee().getEmployeeId());
        System.out.println(employee.get());
        Salaries salaries = modelMapper.map(salaryDto,Salaries.class);
        salaries.setEmployee(employee.get());

        salaryDataRepo.save(salaries);

        return modelMapper.map(salaries,SalaryDto.class);
    }

    @Override
    public SalaryDto getSalaryById(Long employee_id) {
        Optional<Salaries> salaryList = salaryDataRepo.findById(employee_id);
        Salaries salary=salaryList.get();
       // SalaryDto salaryDto=SalaryMapper.mapToSalaryDto(salary);
        //employee.setEmployeeId(salaryDto.getEmployeeId());
        System.out.println(salaryList);
        return modelMapper.map(salary,SalaryDto.class);
    }

    @Override
    public List<SalaryDto> getAllSalary() {
        List<Salaries> salaryList = salaryDataRepo.findAll();

        return salaryList.stream()
                .map(salary -> modelMapper.map(salary, SalaryDto.class))
                .collect(Collectors.toList());    }


    @Override
    public SalaryDto updateSalary(Long id, SalaryDto salaryDto) {
        return null;
    }

    @Override
    public void deleteSalary(Long id) {}
}
