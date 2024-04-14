package com.managementportal.ems.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="salaries")

public class Salaries {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long salaryId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employeeId;
    private Long basic_salary;
    private Long bonus;
    private Long deduction;
    private Long total_salary;
}
