package com.example.atzfinance.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.atzfinance.WebSecurity.CustomAuthenticationSuccessHandler;
 
@Controller
public class MainController {

    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request) throws Exception {
        String referer = null;//request.getHeader("Referer");
        request.getSession().setAttribute(CustomAuthenticationSuccessHandler.REDIRECT_URL_SESSION_ATTRIBUTE_NAME, referer); 
        return "login"; 
    }
}