package com.managementportal.ems.Repository;

import com.managementportal.ems.dto.EmployeeWithSalary;
import com.managementportal.ems.entity.SalaryTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SalaryDataRepo extends JpaRepository<SalaryTable, Long> {

    @Query("SELECT e.firstname,e.lastname,e.email , s.basic_salary " +
            "FROM EmployeeTable e JOIN e.salary s " +
            "WHERE e.employeeId = :employeeid")
    List<EmployeeWithSalary> findEmployeeSalaries(@Param("employeeid") int employeeid);
}
