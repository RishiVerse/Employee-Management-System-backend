package com.managementportal.ems.Repository;

import com.managementportal.ems.entity.DepartmentTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<DepartmentTable, Long> {
}
