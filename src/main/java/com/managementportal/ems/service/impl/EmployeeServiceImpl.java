package com.managementportal.ems.service.impl;

import com.managementportal.ems.Repository.EmployeeRepository;
import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.entity.EmployeeTable;
import com.managementportal.ems.service.EmployeeService;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;


@Component
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;
    static Set<EmployeeDto> empDuplicateSet = Collections.synchronizedSet(new HashSet<>());

    @Override
    public List<EmployeeDto> createBulkEmployee(List<EmployeeDto> employeeDtos) {
        List<EmployeeTable> employeeTables = new ArrayList<>();
        empDuplicateSet.clear();

        // Collections.sort(employeeTables);

        for (var employeeEach : employeeDtos) {
            EmployeeTable emp = new EmployeeTable();

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
                employeeTables.add(emp);
            }
        }

        // Save only non-duplicate employeeTables
        List<EmployeeTable> savedEmployeeTables = employeeRepository.saveAll(employeeTables);

        return savedEmployeeTables.stream()
                .map(salary -> modelMapper.map(salary, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean createEmployee(EmployeeDto empdto) {
        EmployeeTable employeeTable = modelMapper.map(empdto, EmployeeTable.class);
        String email = empdto.getEmailAddress();
        boolean flag = false;

        logger.info("Search for duplicate employeeTable started");

        // Check if an employeeTable with the same email already exists
        if (employeeRepository.findByEmail(email).isPresent()) {
            logger.error("Duplicate employeeTable found with email: {}", email);
            throw new RuntimeException("EmployeeTable with email " + email + " already exists.");
        }

        try {
            // Save the new employeeTable
            EmployeeTable savedEmployeeTable = employeeRepository.save(employeeTable);
            logger.info("EmployeeTable created successfully with email: {}", email);
            flag = true;
            return flag;
        } catch (DataIntegrityViolationException e) {
            logger.error("Data integrity violation while saving employeeTable with email: {}. Error: {}", email, e.getMessage());
            throw new RuntimeException("Data integrity violation: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.error("An error occurred while saving employeeTable with email: {}. Error: {}", email, e.getMessage());
            throw new RuntimeException("An unexpected error occurred: " + e.getMessage(), e);
        }
    }


    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Optional<EmployeeTable> employee;
        try {
            logger.error("trying to find employee with id : {}", id);
            employee = employeeRepository.findById(id);
            if (employee.isEmpty()) {
                logger.error("can't find employee in service class with id {}", id);
                return null;
            }
            return modelMapper.map(employee, EmployeeDto.class);


        } catch (Exception e) {
            logger.error("error occured to find employee with id {}", id);
            return null;

        }


    }


    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<EmployeeTable> emp = null;
        try {
            logger.info("trying to access all employee list");
            emp = employeeRepository.findAll();
            if (emp.isEmpty()) {
                logger.warn("employee list is empty");
                return null;
                //throw new RuntimeException("No employee is present , first insert some employee");
            }
            return emp.stream()
                    .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                    .collect(Collectors.toList());

        } catch (DataAccessException e) {
            logger.error("Can't access data for employee from DB");
            return null;
        } catch (Exception e) {
            logger.error("No employee is available");
            return null;
        }


    }

    @Override
    public Boolean updateEmployee(Long id, EmployeeDto empdto) {
        EmployeeTable emp = null;
        boolean updateFlag = false;
        try {
            logger.info("trying to update employee with id {}", id);

            Optional<EmployeeTable> optionalEmp = employeeRepository.findById(id);
            if (optionalEmp.isPresent()) {
                emp = optionalEmp.get();
                emp.setEmail(empdto.getEmailAddress());
                emp.setFirstname(empdto.getFirstname());
                emp.setLastname(empdto.getLastname());
                employeeRepository.save(emp);
                updateFlag = true;
                logger.info("employee updated with id : {}", id);
                return updateFlag;
            } else {
                logger.error("employee with employee id : {} not found", id);
                throw new RuntimeException("no employee is present");
            }
        } catch (Exception e) {
            logger.error("can not update employee with id {}{}", id, e.getMessage());
            return updateFlag;

        }

    }

    @Override
    public boolean deleteEmployee(Long id) {
        logger.info("About to delete employee with id {}", id);

        try {
            Optional<EmployeeTable> emp = employeeRepository.findById(id);

            if (emp.isEmpty()) {
                logger.warn("No employee found with id {}", id);
                return false;
            }

            employeeRepository.deleteById(id);
            logger.info("EmployeeTable with id {} deleted successfully", id);
            return true;
        } catch (Exception e) {
            logger.error("An error occurred while deleting employee with id {}: {}", id, e.getMessage(), e);
            return false;
        }
    }


}
