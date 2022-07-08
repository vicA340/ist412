package com.example.atzfinance.web;


import com.example.atzfinance.dto.UserRegistrationDto;
import com.example.atzfinance.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        Login login = new Login();
        model.addAttribute("login", login);
        return "login";
    }

    @PostMapping
    public String login(@ModelAttribute("login") Login login) {

        if (login.getPassword() == "password") {
            return "redirect:/";
        }

        return "redirect:/";
    }
}
