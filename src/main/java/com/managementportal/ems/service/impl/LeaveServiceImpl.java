package com.managementportal.ems.service.impl;

import com.managementportal.ems.Repository.LeaveRepo;
import com.managementportal.ems.Utility.WriteLogsInFiles;
import com.managementportal.ems.dto.LeaveDto;
import com.managementportal.ems.dto.TestLeaves;
import com.managementportal.ems.entity.LeavesTable;
import com.managementportal.ems.service.LeaveService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class LeaveServiceImpl implements LeaveService {

    final Logger logger = LoggerFactory.getLogger(LeaveServiceImpl.class);
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private LeaveRepo leaveRepo;

    @Autowired
    private WriteLogsInFiles writeLogsInFiles;


    @Override
    public LeaveDto createLeave(LeaveDto leaveDto) {
        System.out.println(leaveDto);

        LeavesTable leavesTable = modelMapper.map(leaveDto, LeavesTable.class);
        // String email = leaveDto.getEmailAddress();
        System.out.println(leavesTable);
        boolean flag = false;

        writeLogsInFiles.printLogs("This is Create leaves Service method \n", "leavesLogs");

        try {

            logger.info("creating leaves record ");

            LeavesTable savedLeaveTable = leaveRepo.save(leavesTable);

            logger.info("Leaves created successfully");

            writeLogsInFiles.printLogs("Leaves created successfully", "leavesLogs");
            return leaveDto;
        } catch (DataIntegrityViolationException e) {
            logger.error("Data integrity violation while saving leaveTable Error: {}", e.getMessage());
            writeLogsInFiles.printLogs(e.getMessage() + "\n", "leavesLogs");
            throw new RuntimeException("Data integrity violation: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.error("An error occurred while saving leaveTable. Error: {}", e.getMessage());
            //writeLogsInFiles.printLogs(e.getMessage() + "\n");
            throw new RuntimeException("An unexpected error occurred: " + e.getMessage(), e);
        }
    }

    @Override
    public LeaveDto getLeaveById(Long id) {
        return null;
    }

    @Override
    public List<TestLeaves> getAllLeaves() {

        List<LeavesTable> leaves = null;
        try {
            logger.info("Trying to access all leaves");
            leaves = leaveRepo.findAll();

            if (leaves.isEmpty()) {
                logger.warn("No leaves found");
                return null;
            }
        } catch (DataAccessException e) {
            logger.error("Database access error while retrieving leaves. Error: {}", e.getMessage());
            throw new RuntimeException("Database access error: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.error("An unexpected error occurred while retrieving leaves. Error: {}", e.getMessage());
            throw new RuntimeException("An unexpected error occurred: " + e.getMessage(), e);
        }
        return leaves.stream()
                .map(leave -> modelMapper.map(leave, TestLeaves.class))
                .collect(Collectors.toList());


    }


    @Override
    public Boolean updateLeave(Long id, LeaveDto leaveDto) {
        return null;
    }

    @Override
    public boolean deleteLeave(Long id) {
        return false;
    }
}
