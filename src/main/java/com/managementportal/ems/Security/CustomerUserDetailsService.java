package com.managementportal.ems.Security;


import com.managementportal.ems.Repository.AuthService;
import com.managementportal.ems.entity.Register;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;



@Component
@AllArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {



    @Autowired
    private AuthService userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Register register=userRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("username not found"));




        Collection<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));

        return new org.springframework.security.core.userdetails.User(
                register.getEmail(),
                register.getPassword(),
                authorities
        );
    }
}
