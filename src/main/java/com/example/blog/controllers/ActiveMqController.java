package com.example.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;


@RestController
@RequestMapping("/api/active")
public class ActiveMqController {
    @Autowired
    private JmsTemplate jmsTemplate;
    @GetMapping("/gets")
    public String Get(){
        jmsTemplate.convertAndSend("messages", "Hello activeMq");
        return "Hello";
    }

    @GetMapping("/gets2")
    public String Get1() throws JMSException {
        Message messages = jmsTemplate.receive("messages");
        TextMessage textMessage = (TextMessage) messages;
        return textMessage.getText();
    }
}
