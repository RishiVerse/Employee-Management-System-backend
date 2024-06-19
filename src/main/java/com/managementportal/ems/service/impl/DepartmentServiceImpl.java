package com.managementportal.ems.service.impl;

import com.managementportal.ems.dto.DepartmentDto;
import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public boolean createDepartment(DepartmentDto DepartmentDto) {
        return false;
    }

    @Override
    public EmployeeDto getDepartmentById(Long id) {
        return null;
    }

    @Override
    public List<EmployeeDto> getAllDepartments() {
        return List.of();
    }

    @Override
    public Boolean updateDepartment(Long id, DepartmentDto DepartmentDto) {
        return null;
    }

    @Override
    public boolean deleteDepartment(Long id) {
        return false;
    }
}
