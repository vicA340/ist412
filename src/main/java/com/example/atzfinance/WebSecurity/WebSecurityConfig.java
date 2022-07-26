package com.example.atzfinance.WebSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
 
@Configuration
public class WebSecurityConfig {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean 
    PasswordEncoder passwordEncoder() {
        return OurPasswordEncoder.encoder;
    }

    @Bean 
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService);
        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

        http.authenticationManager(authenticationManager)
                .authorizeRequests()
                .antMatchers("/", "/register").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                // TODO: https://stackoverflow.com/questions/14573654/spring-security-redirect-to-previous-page-after-successful-login
                .defaultSuccessUrl("/dashboard", true)
                .permitAll()
                .and()
            .logout()
                .permitAll();
        return http.build();
    }
}