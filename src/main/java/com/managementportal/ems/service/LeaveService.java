package com.managementportal.ems.service;

import com.managementportal.ems.dto.EmployeeDto;
import com.managementportal.ems.dto.LeaveDto;
import com.managementportal.ems.dto.TestLeaves;

import java.util.List;

public interface LeaveService {

    LeaveDto createLeave(LeaveDto leaveDto);

    LeaveDto getLeaveById(Long id);

    List<TestLeaves> getAllLeaves();

    Boolean updateLeave(Long id, LeaveDto leaveDto);

    boolean deleteLeave(Long id);

}
