package com.managementportal.ems.service;

import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    boolean createDepartment(DepartmentDto DepartmentDto);

    EmployeeDto getDepartmentById(Long id);

    List<EmployeeDto> getAllDepartments();

    Boolean updateDepartment(Long id, DepartmentDto DepartmentDto);

    boolean deleteDepartment(Long id);

}
