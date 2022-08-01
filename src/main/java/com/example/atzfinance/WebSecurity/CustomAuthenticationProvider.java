package com.example.atzfinance.WebSecurity;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.example.atzfinance.Model.User;
import com.example.atzfinance.Service.LoginService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    LoginService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        User foundUser = userDetailsService.loadUserByUsername(name);
        if (foundUser != null && OurPasswordEncoder.encoder.matches(password, foundUser.getPassword())) {
            return new UsernamePasswordAuthenticationToken(name, foundUser.getPassword(), new ArrayList<>());
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}