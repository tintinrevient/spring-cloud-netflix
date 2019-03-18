package io.github.tintinrevient.messageservice.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import io.github.tintinrevient.messageservice.model.Message;
import io.github.tintinrevient.messageservice.dao.MessageRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.List;

@RestController
public class MessageController {

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping(value = "/message")
    public List<Message> getAllMessages() {
        logger.info("message service is called.");
        return messageRepository.findAll();
    }

    @GetMapping(value = "/message/{id}")
    public List<Message> findById(@PathVariable("id") int id) {
        logger.info("message service is called.");
        return messageRepository.findById(id);
    }

    @PostMapping(value = "/message")
    public boolean saveMessage(@RequestBody Message message) {
        logger.info("message service is called.");
        messageRepository.save(message);
        return true;
    }

}