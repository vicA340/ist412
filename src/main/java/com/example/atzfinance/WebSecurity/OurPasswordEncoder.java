package com.example.atzfinance.WebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class OurPasswordEncoder {
    public final static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
}
