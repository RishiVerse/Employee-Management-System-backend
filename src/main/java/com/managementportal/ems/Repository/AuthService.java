package com.managementportal.ems.Repository;

import com.managementportal.ems.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthService extends JpaRepository<Register, Long> {
    Optional<Register> findByEmail(String email);

}
