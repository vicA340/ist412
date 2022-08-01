package com.example.atzfinance.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atzfinance.Repository.MessageRepository;
import com.example.atzfinance.Model.Message;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessages() {
        return this.messageRepository.findAll();
    }

    public void saveMessage(Message message) {
        this.messageRepository.save(message);
    }

    public Message getMessageById(long id) throws RuntimeException {
        Optional<Message> optional = messageRepository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Message not found for id :: " + id);
        }
        return optional.get();
    }
}
