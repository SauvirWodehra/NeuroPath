package com.sauvir.NeuroPath.config;

import com.sauvir.NeuroPath.UserProfile.repository.UsersRepository;
import com.sauvir.NeuroPath.UserProfile.model.Users;
import com.sauvir.NeuroPath.UserProfile.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users u = repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(
                u.getUsername(), u.getPassword(),
                Collections.emptyList()  // or map u.getRole() to authorities
        );
    }
}
