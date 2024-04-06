package com.managementportal.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="Register")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String role;
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name ="user_id",referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name ="role_id",referencedColumnName = "id"))
//    private Set<Role> roles;


    public Register(String name, String username, String email, String password) {
    }
}

