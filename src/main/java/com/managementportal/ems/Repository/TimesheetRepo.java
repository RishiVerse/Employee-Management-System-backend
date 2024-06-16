package com.managementportal.ems.Repository;

import com.managementportal.ems.entity.TimesheetTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimesheetRepo extends JpaRepository<TimesheetTable, Long> {
}
