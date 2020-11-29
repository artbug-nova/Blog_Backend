package com.example.blog.controllers;

import com.example.blog.mq.Producer;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {
    @Autowired
    private RabbitTemplate rabbitTemplate;



    @GetMapping("/gets")
    public String Get(){
        //producer.produce();
        return "dasda";
    }

    @GetMapping("/getMessage")
    public String GetMessage(){
        String resp = (String)rabbitTemplate.convertSendAndReceive("myrabbitmq.direct", "myrabbitmq.routingkey", "Hello rabbit");
        Message aa = rabbitTemplate.receive("myrabbitmq.queue", 5000);
        String mes = new String(aa.getBody());
        return mes;
    }
}
