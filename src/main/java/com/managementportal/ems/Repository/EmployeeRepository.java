package com.managementportal.ems.Repository;


import com.managementportal.ems.entity.Employee;
import com.managementportal.ems.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<Employee> findByEmail(String email);
    Optional<Employee> findByEmployeeId(Long employee_id);
}
