package com.managementportal.ems.Repository;

import com.managementportal.ems.entity.LeavesTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepo extends JpaRepository<LeavesTable, Integer> {
}
