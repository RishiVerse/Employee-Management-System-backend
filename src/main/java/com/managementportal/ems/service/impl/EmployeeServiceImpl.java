package com.managementportal.ems.service.impl;

import com.managementportal.ems.Repository.EmployeeRepository;
import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.dto.SalaryDto;
import com.managementportal.ems.entity.Employee;
import com.managementportal.ems.exception.ResourceNotFoundException;
import com.managementportal.ems.service.EmployeeService;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    static Set<EmployeeDto> empDuplicateSet = Collections.synchronizedSet(new HashSet<>());

    @Override
    public List<EmployeeDto> createBulkEmployee(List<EmployeeDto> employeeDtos) {
        List<Employee> employees = new ArrayList<>();
        empDuplicateSet.clear();

       // Collections.sort(employees);

        for (var employeeEach : employeeDtos) {
            Employee emp = new Employee();

            // Check if employee with the same email already exists
            if (employeeRepository.findByEmail(employeeEach.getEmailAddress()).isPresent() ||
                    employeeRepository.findByEmployeeId(employeeEach.getEmployeeId()).isPresent()) {
                empDuplicateSet.add(employeeEach);
            } else {
                emp.setEmail(employeeEach.getEmailAddress());
                emp.setEmployeeId(employeeEach.getEmployeeId());
                emp.setFirstname(employeeEach.getFirstname());
                emp.setLastname(employeeEach.getLastname());
                emp.setAddress(employeeEach.getAddress());
                employees.add(emp);
            }
        }

        // Save only non-duplicate employees
        List<Employee> savedEmployees = employeeRepository.saveAll(employees);

        return savedEmployees.stream()
                .map(salary -> modelMapper.map(salary, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto empdto) {
        Employee employee = modelMapper.map(empdto, Employee.class);
        String email = empdto.getEmailAddress();

        // Check if an employee with the same email already exists
        if (employeeRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Employee with email " + email + " already exists.");
        }

        // Save the new employee
        employeeRepository.save(employee);
       // System.out.println(employee.getEmail());

        return modelMapper.map(employee, EmployeeDto.class);
    }


    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Resource not found"+id));
        return modelMapper.map(employee, EmployeeDto.class);
    }



    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> emp=employeeRepository.findAll();
        return emp.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id,EmployeeDto empdto) {
        Employee emp=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource not present"));
        emp.setEmail(empdto.getEmailAddress());
        emp.setFirstname(empdto.getFirstname());
        emp.setLastname(empdto.getLastname());
        employeeRepository.save(emp);

        return modelMapper.map(emp, EmployeeDto.class);

    }

    @Override
    public void deleteEmployee(Long id) {

        Employee emp=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource not present"));
        employeeRepository.deleteById(id);

    }


}
