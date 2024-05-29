package com.managementportal.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "departments")
@NamedQueries({
        @NamedQuery(name = "Department.updateBy", query = "update Department d set ")
})
public class Department {

    @Id
    @Column(name = "department_id" )
    private Long departmentId;
    @Column(name = "name" )
    private String name;
    @Column(name = "description" )
    private String description;
}
