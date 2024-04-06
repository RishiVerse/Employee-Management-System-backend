package com.managementportal.ems.Security;


import com.managementportal.ems.Repository.AuthService;
import com.managementportal.ems.entity.Register;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {



    private AuthService userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Register register=userRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("username not found"));



//        Set<GrantedAuthority> authorities=register.getRoles().stream()
//                .map((role ->new SimpleGrantedAuthority(role.getName())))
//                .collect(Collectors.toSet());
        Collection<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));

        return new org.springframework.security.core.userdetails.User(
                register.getEmail(),
                register.getPassword(),
                authorities
        );
    }
}
