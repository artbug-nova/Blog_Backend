package com.example.blog.mq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ProducerImpl implements Producer {

    /*@Bean
    MessageListenerAdapter listenerAdapter(Consumer receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }
    @Bean
    Consumer receiver() {
        return new Consumer();
    }*/

    private final static String routing = "myrabbitmq.routingkey";
    private final static String queue = "myrabbitmq.queue";
    private final static  String exchange = "myrabbitmq.direct";



    @Bean
    public Queue queue(){
        return new Queue(queue,  false, false, false);
    }

    @Bean
    public DirectExchange topicExchange(){
        return new DirectExchange(exchange);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with(routing);
    }

    public void produce(){
        //this.rabbitTemplate.convertAndSend();
    }
}
