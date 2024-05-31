package com.managementportal.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Column(name = "email_address")
    private String email;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name" )
    private String lastname;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Id
    @Column(name = "employee_id")
    private Long employeeId;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
    private List<Salaries> salary;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employeeId")
    private List<Leaves> leave;



}
