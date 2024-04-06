package com.managementportal.ems.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name" )
    private String lastname;

    @Column(name = "email_address", nullable = false,unique = true)
    private String email;

    private String role;

    //private Map<String,Integer> skills;


    public Employee(Long id, String firstname, String lastname, String email) {
    }
}
