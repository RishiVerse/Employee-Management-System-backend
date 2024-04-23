package com.managementportal.ems.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="salaries")

public class Salaries {

    @Id
    private Long salaryId;
    private Long basic_salary;
    private Long bonus;
    private Long deduction;
    private Long total_salary;



}
