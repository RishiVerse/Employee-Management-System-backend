package com.managementportal.ems.Repository;

import com.managementportal.ems.entity.WorkPerformanceTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepo extends JpaRepository<WorkPerformanceTable, Long> {
}
