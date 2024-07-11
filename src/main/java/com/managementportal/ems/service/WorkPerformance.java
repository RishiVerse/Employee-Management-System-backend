package com.managementportal.ems.service;

import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.dto.PerformanceDto;

import java.util.List;

public interface WorkPerformance {

    PerformanceDto createWorkPerformance(PerformanceDto performanceDto);

    PerformanceDto getWorkPerformanceById(Long id);

    List<PerformanceDto> getAllWorkPerformance();

    Boolean updateWorkPerformance(Long id, PerformanceDto performanceDto);

    boolean deleteWorkPerformance(Long id);
}
