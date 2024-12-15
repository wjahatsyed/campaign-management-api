package com.adiltech.campaign_management_api.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Replace this with your actual user-fetching logic
        if ("admin".equals(username)) {
            return new User("admin", new BCryptPasswordEncoder().encode("password"),
                    Collections.singletonList(() -> "ROLE_ADMIN"));

        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
