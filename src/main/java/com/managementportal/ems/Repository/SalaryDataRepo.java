package com.managementportal.ems.Repository;

import com.managementportal.ems.entity.SalaryTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryDataRepo extends JpaRepository<SalaryTable, Long> {

}
