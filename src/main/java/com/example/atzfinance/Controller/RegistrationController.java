package com.example.atzfinance.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.atzfinance.Model.User;
import com.example.atzfinance.Repository.UserRepository;
import com.example.atzfinance.WebSecurity.OurPasswordEncoder;

@Controller
public class RegistrationController {
    
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/register")
    public String showRegistrationForm(Model model, Authentication authentication) {
        if (authentication != null) return "redirect:/dashboard";
        model.addAttribute("user", new User());
        return "Registration/signup_form";
    }

    @PostMapping("/register")
    public String processRegister(User user) {
        if (userRepo.findByEmail(user.getUsername()) != null) {
            return "redirect:/register?error";
        }
        String encodedPassword = OurPasswordEncoder.encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepo.save(user);
        return "Registration/signup_complete";
    }
}
