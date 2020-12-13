package com.example.blog.controllers;

import com.example.blog.mqactive.Action;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.xml.crypto.dsig.XMLObject;


@RestController
@RequestMapping("/api/active")
public class ActiveMqController {
    @Autowired
    private JmsTemplate jmsTemplate;
    @GetMapping("/gets")
    public String Get() throws JsonProcessingException {
        Action action = new Action();
        action.setAge(14);
        action.setName("Alex");
        ObjectMapper jsonMapper = new ObjectMapper();
        String json = jsonMapper.writeValueAsString(action);
        XmlMapper xmlMapper = new XmlMapper();
        val xml = xmlMapper.writeValueAsString(action);
        jmsTemplate.convertAndSend("messages", json);
        jmsTemplate.convertAndSend("messages", xml);
        return "Hello";
    }

    @GetMapping("/gets2")
    public String Get1() throws JMSException {
        Message messages = jmsTemplate.receive("messages");
        TextMessage textMessage = (TextMessage) messages;
        return textMessage.getText();
    }

    @GetMapping("/gets3")
    public String Get3() throws JsonProcessingException {
        Action action = new Action();
        action.setAge(14);
        action.setName("Alex");
        ObjectMapper jsonMapper = new ObjectMapper();
        String json = jsonMapper.writeValueAsString(action);
        val aa = jsonMapper.readValue(json, Action.class);
        XmlMapper xml = new XmlMapper();
        val ss = xml.writeValueAsString(aa);
        val cc = xml.readValue(ss, Action.class);

        return json;
    }
}
