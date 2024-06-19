package com.managementportal.ems.service;

import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.dto.PerformanceDto;

import java.util.List;

public interface WorkPerformance {

    boolean createWorkPerformance(PerformanceDto performanceDto);

    EmployeeDto getWorkPerformanceById(Long id);

    List<EmployeeDto> getAllWorkPerformance();

    Boolean updateWorkPerformance(Long id, PerformanceDto performanceDto);

    boolean deleteWorkPerformance(Long id);
}
