package com.example.atzfinance.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.atzfinance.Model.FormTest;

@Controller
public class FormTestController {
    @GetMapping("/test")
    public String GetForm(Model model) {
      model.addAttribute("TEST", new FormTest());
      return "Test/GetData";
    }
  
    @PostMapping("/test")
    public String PostSubmit(@ModelAttribute FormTest test, Model model) {
      model.addAttribute("TEST", test);
      return "Test/PostData";
    }
}
