package com.managementportal.ems.Repository;

import com.managementportal.ems.entity.SalaryTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface SalaryDataRepo extends JpaRepository<SalaryTable, Long> {

    @Query("SELECT e.email " +
            "FROM EmployeeTable e JOIN e.salary s " +
            "WHERE e.employeeId = :employeeid")
    String findEmployeeSalaries(@Param("employeeid") int employeeid);
}
