package com.example.rabbitmqlistener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PizzaListener {

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(RabbitPizza pizza){
        System.out.println(pizza);
    }
}
