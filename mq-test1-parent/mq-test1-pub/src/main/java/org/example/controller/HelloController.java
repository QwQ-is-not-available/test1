package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @RequestMapping("/hello1")
    public String hello() {
        log.info("Hello World 1 in pub");
        return "Hello World 1 in pub";
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/mqtest1")
    public String mqtest1() {
        //test without exchange, just one queue
        String queueName = "hello.queue1";
        String msg = "Hello World 1 in cons";
        log.info("mq publisher send message: "+msg+" to queue: "+queueName);

        rabbitTemplate.convertAndSend(queueName, msg);
        return "mq publisher send message: "+msg+" to queue: "+queueName;

    }

    @RequestMapping("/mqtest2")
    public String mqtest2() {
        //test fanout exchange
        String exchangeName = "test1.fanout";
        String msg = "Hello World 1 in cons";
        log.info("mq publisher send message: "+msg+" to exchange: "+exchangeName);

        rabbitTemplate.convertAndSend(exchangeName,null, msg);
        return "mq publisher send message: "+msg+" to exchange: "+exchangeName;
    }

    @RequestMapping("/mqtest3")
    public String mqtest3() {
        //test direct exchange
        String exchangeName = "test1.direct";
        String msg = "Hello World 1 in cons";
        log.info("mq publisher send message: "+msg+" to exchange: "+exchangeName);

        rabbitTemplate.convertAndSend(exchangeName,"red", msg);
        return "mq publisher send message: "+msg+" to exchange: "+exchangeName;
    }

}