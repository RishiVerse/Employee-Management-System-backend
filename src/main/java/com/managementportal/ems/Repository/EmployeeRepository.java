package com.managementportal.ems.Repository;


import com.managementportal.ems.entity.EmployeeTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeTable, Long> {

    Optional<EmployeeTable> findByEmail(String email);

    Optional<EmployeeTable> findByEmployeeId(Long employee_id);
}
