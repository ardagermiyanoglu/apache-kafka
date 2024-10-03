package com.ardagermiyanoglu.apache_kafka.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventService {

    private final KafkaTemplate<String,Object> kafkaTemplate;

    @Value("${kafka.topic}")
    private String topic;

    public EventService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Object message){
        this.kafkaTemplate.send(topic,message);
        System.out.println("Event sent to kafka : " + message);
    }
}
