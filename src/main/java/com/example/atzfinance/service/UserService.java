package com.example.atzfinance.service;

import com.example.atzfinance.dto.UserRegistrationDto;
import com.example.atzfinance.model.User;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}

