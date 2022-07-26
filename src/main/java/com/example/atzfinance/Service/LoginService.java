package com.example.atzfinance.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.atzfinance.Model.User;
import com.example.atzfinance.Repository.UserRepository;

@Service
public class LoginService implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepo;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        return user;            
    }
}