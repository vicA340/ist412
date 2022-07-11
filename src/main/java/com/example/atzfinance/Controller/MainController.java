package com.example.atzfinance.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
 
@Controller
public class MainController {
     
    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/dashboard")
    public String hello() {
        return "dashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}