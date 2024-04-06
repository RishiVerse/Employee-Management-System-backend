package com.managementportal.ems.service.impl;

import com.managementportal.ems.Repository.EmployeeRepository;
import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.entity.Employee;
import com.managementportal.ems.exception.ResourceNotFoundException;
import com.managementportal.ems.mapper.EmployeeMapper;
import com.managementportal.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto empdto) {

        Employee employee= EmployeeMapper.mapToEmployee(empdto);
        employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Resource not found"+id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> emp=employeeRepository.findAll();
        return emp.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id,EmployeeDto empdto) {
        Employee emp=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource not present"));
        emp.setEmail(empdto.getEmail());
        emp.setFirstname(empdto.getFirstname());
        emp.setLastname(empdto.getLastname());
        employeeRepository.save(emp);

        return EmployeeMapper.mapToEmployeeDto(emp);

    }

    @Override
    public void deleteEmployee(Long id) {

        Employee emp=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource not present"));
        employeeRepository.deleteById(id);

    }


}
