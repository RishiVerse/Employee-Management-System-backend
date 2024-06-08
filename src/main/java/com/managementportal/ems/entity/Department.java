package com.managementportal.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @Column(name = "department_id" )
    private Long departmentId;
    @Column(name = "name" )
    private String name;
    @Column(name = "description" )
    private String description;
    @ManyToMany
    private List<Employee> employees;



}
