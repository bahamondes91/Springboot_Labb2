package com.example.rabbitmqlistener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RabbitPizza {

    private String id;
    private String name;
    private String ingridients;
    private int price;

}
