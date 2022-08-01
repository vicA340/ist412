package com.example.atzfinance.Controller.Dashboard;

import java.util.List;

import com.example.atzfinance.Model.Message;
import com.example.atzfinance.Service.MessageService;
import com.example.atzfinance.Service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.security.core.Authentication;

@Controller
public class MessageController {

    @Autowired
    LoginService userDetailsService;

    @Autowired
    private MessageService messageService;

    @GetMapping("/messages")
    public String GetMessages(Model model) {
        List<Message> messages = messageService.getAllMessages();
        model.addAttribute("messages", messages);
        model.addAttribute("message", new Message());
        return "Dashboard/messages";
    }

    @PostMapping("/message")
    public String PostMessage(@ModelAttribute Message message, Authentication authentication) {
        message.setSentBy(authentication.getName());
        messageService.saveMessage(message);
        return "redirect:/messages";
    }
}
