package com.managementportal.ems.service.impl;

import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.dto.PerformanceDto;
import com.managementportal.ems.service.WorkPerformance;

import java.util.List;

public class WorkPerformanceServiceImpl implements WorkPerformance {

    @Override
    public boolean createWorkPerformance(PerformanceDto performanceDto) {
        return false;
    }

    @Override
    public EmployeeDto getWorkPerformanceById(Long id) {
        return null;
    }

    @Override
    public List<EmployeeDto> getAllWorkPerformance() {
        return List.of();
    }

    @Override
    public Boolean updateWorkPerformance(Long id, PerformanceDto performanceDto) {
        return null;
    }

    @Override
    public boolean deleteWorkPerformance(Long id) {
        return false;
    }
}
