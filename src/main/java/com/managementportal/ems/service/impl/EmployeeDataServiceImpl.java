package com.managementportal.ems.service.impl;

import com.managementportal.ems.Repository.EmployeeRepository;
import com.managementportal.ems.Repository.SalaryDataRepo;
import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.dto.SalaryDto;
import com.managementportal.ems.entity.Department;
import com.managementportal.ems.entity.Employee;
import com.managementportal.ems.entity.Salaries;
import com.managementportal.ems.mapper.EmployeeMapper;
import com.managementportal.ems.mapper.SalaryMapper;
import com.managementportal.ems.service.EmployeeDataService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeDataServiceImpl implements EmployeeDataService {
    SalaryDataRepo salaryDataRepo;
    EmployeeRepository employeeRepository;

    @Override
    public SalaryDto createSalary(SalaryDto salaryDto) {

        Salaries salaries = SalaryMapper.mapToSalary(salaryDto);
      //  System.out.println(salaries.getEmployee().getEmployeeId());
        salaryDataRepo.save(salaries);
        return SalaryMapper.mapToSalaryDto(salaries);
    }

    @Override
    public SalaryDto getSalaryById(Long employee_id) {
        Optional<Salaries> salaryList = salaryDataRepo.findById(employee_id);
        Salaries salary=salaryList.get();
        SalaryDto salaryDto=SalaryMapper.mapToSalaryDto(salary);
        //employee.setEmployeeId(salaryDto.getEmployeeId());
        System.out.println(salaryList);
        return SalaryMapper.mapToSalaryDto(salary);
    }

    @Override
    public List<SalaryDto> getAllSalary() {
        List<Salaries> salaryList = salaryDataRepo.findAll();
//        for(var v:salaryList) {
//            System.out.println(v.getEmployee());
//        break;}
        //List<Employee> empDetail=employeeRepository.findById()




//        for (Salaries salary : salaryList) {
//            System.out.println("Salary ID: " + salary.getSalaryId());
//           // System.out.println("Employee ID: " + salary.getEmployee().getId());
//            System.out.println("Basic Salary: " + salary.getBasic_salary());
//            // Print other salary details as needed
//           // break;
//        }
        return salaryList.stream().map(SalaryMapper::mapToSalaryDto).toList();
    }


    @Override
    public SalaryDto updateSalary(Long id, SalaryDto salaryDto) {
        return null;
    }

    @Override
    public void deleteSalary(Long id) {

    }
}
