package com.managementportal.ems.Repository;

import com.managementportal.ems.entity.RegisterTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthService extends JpaRepository<RegisterTable, Long> {
    Optional<RegisterTable> findByEmail(String email);

}
