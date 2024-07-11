//package com.managementportal.ems.service.impl;
//
//import com.managementportal.ems.Repository.EmployeeRepository;
//import com.managementportal.ems.Repository.WorkPerformanceRepo;
//import com.managementportal.ems.dto.EmployeeDto;
//import com.managementportal.ems.dto.PerformanceDto;
//import com.managementportal.ems.entity.EmployeeTable;
//import com.managementportal.ems.entity.WorkPerformanceTable;
//import com.managementportal.ems.service.WorkPerformance;
//import org.modelmapper.ModelMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.dao.DataIntegrityViolationException;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class WorkPerformanceServiceImpl implements WorkPerformance {
//
//
//    final Logger logger = LoggerFactory.getLogger(WorkPerformanceServiceImpl.class);
//
//    @Autowired
//    private WorkPerformanceRepo workPerformanceRepo;
//    @Autowired
//    private ModelMapper modelMapper;
//    // static Set<EmployeeDto> empDuplicateSet = Collections.synchronizedSet(new HashSet<>());
//
//    @Override
//    public PerformanceDto createWorkPerformance(PerformanceDto performanceDto) {
//        WorkPerformanceTable workPerformanceTable = modelMapper.map(performanceDto, WorkPerformanceTable.class);
//        // String performanceId = workPerformanceTable.set;
//        boolean flag = false;
//        Long id = workPerformanceTable.getEmployeeTable().getEmployeeId();
//        logger.info("Search for duplicate employeeTable started");
//
//        // Check if an employeeTable with the same email already exists
//        if (workPerformanceRepo.findById(id).isPresent()) {
//            logger.error("Duplicate employeeTable found with email: {}", id);
//            throw new RuntimeException("EmployeeTable with email " + id + " already exists.");
//        }
//
//        try {
//            // Save the new employeeTable
//            WorkPerformanceTable workPerformanceTable1 = workPerformanceRepo.save(workPerformanceTable);
//            logger.info("EmployeeTable created successfully with email: {}", id);
//            return modelMapper.map(workPerformanceTable1, PerformanceDto.class);
//
//        } catch (DataIntegrityViolationException e) {
//            logger.error("Data integrity violation while saving employeeTable with email: {}. Error: {}", email, e.getMessage());
//            throw new RuntimeException("Data integrity violation: " + e.getMessage(), e);
//        } catch (Exception e) {
//            logger.error("An error occurred while saving employeeTable with email: {}. Error: {}", email, e.getMessage());
//            throw new RuntimeException("An unexpected error occurred: " + e.getMessage(), e);
//        }
//    }
//
//    @Override
//    public PerformanceDto getWorkPerformanceById(Long id) {
//        Optional<EmployeeTable> employee;
//        try {
//            logger.error("trying to find employee with id : {}", id);
//            employee = employeeRepository.findById(id);
//            if (employee.isEmpty()) {
//                logger.error("can't find employee in service class with id {}", id);
//                return null;
//            }
//            return modelMapper.map(employee, EmployeeDto.class);
//
//
//        } catch (Exception e) {
//            logger.error("error occured to find employee with id {}", id);
//            return null;
//
//        }
//
//        return null;
//    }
//
//    @Override
//    public List<PerformanceDto> getAllWorkPerformance() {
//        List<EmployeeTable> emp = null;
//        try {
//            logger.info("trying to access all employee list");
//            emp = employeeRepository.findAll();
//            //System.out.println(emp.get(0));
//            if (emp.isEmpty()) {
//                logger.warn("employee list is empty");
//                return null;
//                //throw new RuntimeException("No employee is present , first insert some employee");
//            }
//            return emp.stream()
//                    .map(employee -> modelMapper.map(employee, EmployeeDto.class))
//                    .collect(Collectors.toList());
//
//        } catch (DataAccessException e) {
//            logger.error("Can't access data for employee from DB");
//            return null;
//        } catch (Exception e) {
//            logger.error("No employee is available");
//            return null;
//        }
//        return List.of();
//    }
//
//    @Override
//    public Boolean updateWorkPerformance(Long id, PerformanceDto performanceDto) {
//        EmployeeTable emp = null;
//        boolean updateFlag = false;
//        try {
//            logger.info("trying to update employee with id {}", id);
//
//            Optional<EmployeeTable> optionalEmp = employeeRepository.findById(id);
//            if (optionalEmp.isPresent()) {
//                emp = optionalEmp.get();
//                emp.setEmail(empdto.getEmailAddress());
//                emp.setFirstname(empdto.getFirstname());
//                emp.setLastname(empdto.getLastname());
//                employeeRepository.save(emp);
//                updateFlag = true;
//                logger.info("employee updated with id : {}", id);
//                return updateFlag;
//            } else {
//                logger.error("employee with employee id : {} not found", id);
//                throw new RuntimeException("no employee is present");
//            }
//        } catch (Exception e) {
//            logger.error("can not update employee with id {}{}", id, e.getMessage());
//            return updateFlag;
//
//        }
//
//        return null;
//    }
//
//    @Override
//    public boolean deleteWorkPerformance(Long id) {
//        logger.info("About to delete employee with id {}", id);
//
//        try {
//            Optional<EmployeeTable> emp = employeeRepository.findById(id);
//
//            if (emp.isEmpty()) {
//                logger.warn("No employee found with id {}", id);
//                return false;
//            }
//
//            employeeRepository.deleteById(id);
//            logger.info("EmployeeTable with id {} deleted successfully", id);
//            return true;
//        } catch (Exception e) {
//            logger.error("An error occurred while deleting employee with id {}: {}", id, e.getMessage(), e);
//            return false;
//        }
//        return false;
//    }
//}
