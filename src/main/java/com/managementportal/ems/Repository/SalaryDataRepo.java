package com.managementportal.ems.Repository;

import com.managementportal.ems.entity.Salaries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryDataRepo extends JpaRepository<Salaries, Long> {

}
