package com.example.springboot_labb2;

import com.example.springboot_labb2.entities.Pizza;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.UUID;

@RestController
public class MessagePublisher {

        @Autowired
    private RabbitTemplate template;


    @PostMapping("/publish")
    public RabbitPizza publishMessage(@RequestBody RabbitPizza pizza) {
        pizza.setId(UUID.randomUUID().toString());
        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, pizza);
        return pizza;
    }
}
