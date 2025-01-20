package org.example.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;



@Slf4j
@Component
public class MqRabbitListener {
    @RabbitListener(queues = "hello.queue1")
    public void listenHelloQueue(String message) {
        log.info("mq consumer get message from hello.queue1: {}", message);
    }

    @RabbitListener(queues = "fanout-test1.queue1")
    public void listenFanoutQueue1(String message) {
        log.info("mq consumer get message from fanout-test1.queue1: {}", message);
    }

//    @RabbitListener(queues = "direct-test1.queue1")
//    public void listenDirectQueue1(String message) {
//        log.info("mq consumer get message from direct-test1.queue1: {}", message);
//    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name="direct-test1.queue1",durable = "true"),
            exchange = @Exchange(name = "test1.direct",type = ExchangeTypes.DIRECT),
            key = {"red"}
    ))
    public void listenDirectAutoQueue1(String message) {
        log.info("mq consumer get from direct-test1.queue1 annotation: {}", message);
    }
}
