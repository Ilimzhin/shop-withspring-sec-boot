package org.example.service;

import org.example.entity.User;
import org.example.entity.UserSecurity;
import org.example.repo.UserSecurityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private UserSecurityRepo userSecurityRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userSecurityRepo.findByUsername(username);
    }

    public List<UserSecurity> findAll() {
        return userSecurityRepo.findAll();
    }
}
